package PublicUtils.files;

import PublicUtils.log.LogLevel;
import PublicUtils.log.LogUtil;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by BigBearCoding (c) 2018. All rights reserved.
 * Any code contained within PublicUtils (this document), and any associated APIs with similar branding
 * are the sole property of BigBearCoding.  Distribution, reproduction, taking sections, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with the third-party, you.
 * Thanks.
 * Created on 2/7/2018 at 12:53 PM.
 */
public class SimpleFile {

    private int comments = 0;

    private JavaPlugin plugin;

    private File folder;
    private File file;
    private FileConfiguration config;

    public SimpleFile(File folder, File file, JavaPlugin plugin) {
        this.plugin = plugin;

        this.folder = folder;
        this.file = file;
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public SimpleFile(File folder, String name, JavaPlugin plugin) {
        this.plugin = plugin;

        this.folder = folder;
        this.file = new File(folder, name + ".yml");
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public SimpleFile(File folder, String name, String extension, JavaPlugin plugin) {
        this.plugin = plugin;

        this.folder = folder;
        this.file = new File(folder, name + extension);
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public boolean exists() {
        return folder.exists() || file.exists();
    }

    public boolean createFile() {
        if(!folder.exists()){
            folder.mkdirs();
        }

        if(!file.exists()){
            try{
                return file.createNewFile();
            }catch(IOException e){
                LogUtil.log(LogLevel.WARN, "IOException when trying to create file '" + file.getName() + "'");
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean loadFile() {
        try{
            config.load(file);
            return true;
        }catch(FileNotFoundException e){
            createFile();
            return false;
        }catch(IOException e){
            createFile();
            return false;
        }catch(InvalidConfigurationException e){
            createFile();
            return false;
        }
    }

    public void reload() {
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public boolean saveFile() {
        try{
            config.save(file);
            return true;
        }catch(IOException e){
            LogUtil.log(LogLevel.WARN, "IOException when trying to save file '" + file.getName() + "'");
            return false;
        }
    }

    public void setHeader(String[] header) {
        makeHeader(header);
        this.comments = header.length + 2;
        this.reload();
    }

    private void makeHeader(String[] header) {
        if(exists()) try{
            String currentLine;
            StringBuilder builder = new StringBuilder("");
            BufferedReader reader = new BufferedReader(new FileReader(file));

            while((currentLine = reader.readLine()) != null){
                builder.append(currentLine).append("\n");
            }
            reader.close();
            builder.append("# +----------------------------------------------------+ #\n");

            for(String line : header){
                if(line.length() > 50) continue;
                int length = (50 - line.length()) / 2;
                StringBuilder finalLine = new StringBuilder(line);
                for(int i = 0; i < length; i++){
                    finalLine.append(" ");
                    finalLine.reverse();
                    finalLine.append(" ");
                    finalLine.reverse();
                }
                if(line.length() % 2 != 0){
                    finalLine.append(" ");
                }

                builder.append("# < ").append(finalLine.toString()).append(" > #\n");
            }

            builder.append("# +----------------------------------------------------+ #\n");

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(this.prepareConfigString(builder.toString()));
            writer.flush();
            writer.close();
        }catch(FileNotFoundException e){
            LogUtil.log(LogLevel.WARN, "No File Found when trying to set the header in file '" + file.getName() + "'");
        }catch(IOException e){
            LogUtil.log(LogLevel.WARN, "IOException when trying to set the header in file '" + file.getName() + "'");
        }
    }

    public InputStream getConfigContent() {
        if(!exists()) return null;
        try{
            int commentNum = 0;
            String addLine;
            String currentLine;
            String pluginName = this.plugin.getName();
            StringBuilder whole = new StringBuilder("");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((currentLine = reader.readLine()) != null){
                if(currentLine.startsWith("#")){
                    addLine = currentLine.replaceFirst("#", pluginName + "_COMMENT_" + commentNum + ":");
                    whole.append(addLine).append("\n");
                    commentNum++;
                }else{
                    whole.append(currentLine).append("\n");
                }
            }
            String config = whole.toString();
            InputStream configStream = new ByteArrayInputStream(config.getBytes(Charset.forName("UTF-8")));

            reader.close();
            return configStream;
        }catch(IOException e){
            LogUtil.log(LogLevel.WARN, "IOException when trying to get grabbing input stream in the file '" + file.getName() + "'");
            return null;
        }

    }

    private int getCommentsNum() {
        if(!exists()) return 0;
        try{
            int comments = 0;
            String currentLine;
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while((currentLine = reader.readLine()) != null){
                if(currentLine.startsWith("#")){
                    comments++;
                }
            }
            reader.close();
            return comments;
        }catch(IOException e){
            LogUtil.log(LogLevel.WARN, "IOException when trying to get comments for the file '" + file.getName() + "'");
            return 0;
        }
    }

    private String prepareConfigString(String configString) {
        int lastLine = 0;
        int headerLine = 0;

        String[] lines = configString.split("\n");
        StringBuilder config = new StringBuilder("");

        for(String line : lines){
            if(line.startsWith(this.plugin.getName() + "_COMMENT")){
                String comment = "#" + line.trim().substring(line.indexOf(":") + 1);
                if(comment.startsWith("# +-")){
                    if(headerLine == 0){
                        config.append(comment).append("\n");

                        lastLine = 0;
                        headerLine = 1;
                    }else if(headerLine == 1){
                        config.append(comment + "\n\n");

                        lastLine = 0;
                        headerLine = 0;
                    }
                }else{
                    String normalComment;

                    if(comment.startsWith("# ' ")){
                        normalComment = comment.substring(0, comment.length() - 1).replaceFirst("# ' ", "# ");
                    }else{
                        normalComment = comment;
                    }

                    if(lastLine == 0){
                        config.append(normalComment + "\n");
                    }else if(lastLine == 1){
                        config.append("\n" + normalComment + "\n");
                    }

                    lastLine = 0;
                }
            }else{
                config.append(line + "\n");
                lastLine = 1;
            }
        }
        return config.toString();
    }

    public Object get(String path) {
        return this.config.get(path);
    }

    public Object get(String path, Object def) {
        return this.config.get(path, def);
    }

    public String getString(String path) {
        return this.config.getString(path);
    }

    public String getString(String path, String def) {
        return this.config.getString(path, def);
    }

    public int getInt(String path) {
        return this.config.getInt(path);
    }

    public int getInt(String path, int def) {
        return this.config.getInt(path, def);
    }

    public boolean getBoolean(String path) {
        return this.config.getBoolean(path);
    }

    public boolean getBoolean(String path, boolean def) {
        return this.config.getBoolean(path, def);
    }

    public void createSection(String path) {
        this.config.createSection(path);
    }

    public ConfigurationSection getConfigurationSection(String path) {
        return this.config.getConfigurationSection(path);
    }

    public double getDouble(String path) {
        return this.config.getDouble(path);
    }

    public double getDouble(String path, double def) {
        return this.config.getDouble(path, def);
    }

    public List<?> getList(String path) {
        return this.config.getList(path);
    }

    public List<?> getList(String path, List<?> def) {
        return this.config.getList(path, def);
    }

    public boolean contains(String path) {
        return this.config.contains(path);
    }

    public void removeKey(String path) {
        this.config.set(path, null);
    }

    public Set<String> getKeys(Boolean deep) {
        return this.config.getKeys(deep);
    }

    public Set<String> getKeys(boolean deep) {
        return this.config.getKeys(deep);
    }

    public List<String> getStringList(String path) {
        return this.config.getStringList(path);
    }

    public List<Integer> getIntList(String path) {
        return this.config.getIntegerList(path);
    }

    public List<Map<?, ?>> getMapList(String path) {
        return this.config.getMapList(path);
    }

    public void set(String path, Object value) {
        this.config.set(path, value);
    }

    public void set(String path, Object value, String comment) {
        if(!this.config.contains(path)){
            this.config.set(this.plugin.getName() + "_COMMENT_" + comments, " " + comment);
            comments++;
        }
        this.set(path, value);
    }

    public void set(String path, Object value, String[] comment) {
        for(String comm : comment){
            if(!this.config.contains(path)){
                this.config.set(this.plugin.getName() + "_COMMENT_" + comments, " " + comm);
                comments++;
            }

        }
        this.set(path, value);
    }

    public File getFolder() {
        return folder;
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getConfig() {
        return config;
    }
}