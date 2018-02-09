package PublicUtils.chat;

import PublicUtils.Main;

import java.util.Arrays;
import java.util.List;

/**
 * Created by BigBearCoding (c) 2018. All rights reserved.
 * Any code contained within PublicUtils (this document), and any associated APIs with similar branding
 * are the sole property of BigBearCoding.  Distribution, reproduction, taking sections, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with the third-party, you.
 * Thanks.
 * Created on 2/9/2018 at 10:46 AM.
 */
public enum Lang {

    PREFIX("prefix", "&a[Public Utils]"),
    INVALID_COMMAND("invalid-command", "&c/$command is an unhandled command. Please use &6/help &cand try again.", PlaceholderText.COMMAND),
    INVALID_SYNTAX("invalid-syntax", "&cInvalid Syntax: Please use &c$usage&c.", PlaceholderText.COMMAND, PlaceholderText.USAGE),
    PLAYER_ONLY("player-only", "&cYou must be in-game to perform this command.", PlaceholderText.COMMAND),
    CONSOLE_ONLY("console-only", "&Only console has the ability to perform this command.", PlaceholderText.COMMAND),
    NO_PERMISSIONS("no-perms", "&cYou do not have the necessary permission to perform /$command.", PlaceholderText.COMMAND, PlaceholderText.PERMISSION),
    PLAYER_FAILED("player-fail", "&cPlayer with the name &7'&6$player&7' &cnot found.", PlaceholderText.TARGET);

    private String path;
    private String def;
    private PlaceholderText[] placeholders;

    Lang(String path, String def, PlaceholderText... placeholders) {
        this.path = path;
        this.def = def;
        this.placeholders = placeholders;
    }

    public String replace(PlaceholderText[] placeholders, String[] replacements){
        List<PlaceholderText> ph = Arrays.asList(placeholders);
        List<String> rp = Arrays.asList(replacements);
        String message;
        if(Main.getMain().getLangFile().get(path) != null) message = Main.getMain().getLangFile().getString(path);
        else message = def;
        for(PlaceholderText p : ph){
            if(message.contains(p.getText())) message = message.replace(p.getText(), rp.get(ph.indexOf(p)));
        }
        return message;
    }

    public String getPath() {
        return path;
    }

    public String getDef() {
        return def;
    }

    public PlaceholderText[] getPlaceholders() {
        return placeholders;
    }
}
