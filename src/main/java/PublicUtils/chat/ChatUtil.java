package PublicUtils.chat;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by BigBearCoding (c) 2018. All rights reserved.
 * Any code contained within PublicUtils (this document), and any associated APIs with similar branding
 * are the sole property of BigBearCoding.  Distribution, reproduction, taking sections, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with the third-party, you.
 * Thanks.
 * Created on 2/9/2018 at 10:39 AM.
 */
public class ChatUtil {

    public static void sendMessage(final Player player, String msg){
        if(msg.contains("\n")){
            String[] split = msg.split("\n");
            for (String aSplit : split) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', aSplit));
            }
            return;
        }
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }

    public static void sendMessage(final CommandSender sender, String msg){
        if(msg.contains("\n")){
            String[] split = msg.split("\n");
            for (String aSplit : split) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', aSplit));
            }
            return;
        }
        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
}
