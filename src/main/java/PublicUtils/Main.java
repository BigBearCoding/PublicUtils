package PublicUtils;

import PublicUtils.chat.Lang;
import PublicUtils.chat.PlaceholderText;
import PublicUtils.files.SimpleFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BigBearCoding (c) 2018. All rights reserved.
 * Any code contained within PublicUtils (this document), and any associated APIs with similar branding
 * are the sole property of BigBearCoding.  Distribution, reproduction, taking sections, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with the third-party, you.
 * Thanks.
 * Created on 2/9/2018 at 10:48 AM.
 */
public class Main extends JavaPlugin {

    /*
      THIS CLASS IS SIMPLY HERE AS A PLACEHOLDER
      ITS MAIN PURPOSE IS TO BE A GUIDE FOR YOUR MAIN CLASS
     */

    @Override
    public void onEnable() {
        main = this;
    }

    private static Main main;

    public static Main getMain() {
        return main;
    }

    public void registerLangFile(){
        langFile = new SimpleFile(getDataFolder(), "language", this);
        if(!langFile.exists()) langFile.createFile();
        langFile.loadFile();
        langFile.setHeader(new String[]{"In this language file are all the messages that",
                "are able to be edited Any word that contains a $",
                "in front of it, such as $command or $target, will be",
                "replaced with the necessary information.",
                "Before each message you will see the available",
                "placeholders and what they will change."});
        for(Lang item : Lang.values()){
            if(langFile.getString(item.getPath()) == null){
                List<String> comments = new ArrayList<String>();
                for(PlaceholderText ph : item.getPlaceholders()){
                    comments.add(ph.getText() + " -> " + ph.getDescription());
                }
                langFile.set(item.getPath(), item.getDef(), comments.toArray(new String[0]));
            }
        }
    }

    private SimpleFile langFile;

    public SimpleFile getLangFile(){
        return langFile;
    }
}
