package PublicUtils.chat;

/**
 * Created by BigBearCoding (c) 2018. All rights reserved.
 * Any code contained within PublicUtils (this document), and any associated APIs with similar branding
 * are the sole property of BigBearCoding.  Distribution, reproduction, taking sections, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with the third-party, you.
 * Thanks.
 * Created on 2/9/2018 at 11:08 AM.
 */
public enum PlaceholderText {

    COMMAND("$command", "Replaced with the name of the command the sender is trying to execute"),
    PERMISSION("$permission", "Replaced with the permission required to send the executed command"),
    USAGE("$permission", "Replaced with the usage of the executed command"),
    PLAYER("$player", "Replaced with the senders name"),
    TARGET("$target", "Replaced with the targets name");

    private String text;
    private String description;

    PlaceholderText(String text, String description) {
        this.text = text;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }
}
