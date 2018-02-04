package PublicUtils.log;

import PublicUtils.SystemColor;
import org.bukkit.Bukkit;

/**
 * Created by BigBearCoding (c) 2018. All rights reserved.
 * Any code contained within PublicUtils (this document), and any associated APIs with similar branding
 * are the sole property of BigBearCoding.  Distribution, reproduction, taking sections, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with the third-party, you.
 * Thanks.
 * Created on 9/9/2017 at 8:36 PM.
 */
public class LogUtil {

    public static void log(String msg){
        log(LogLevel.DEFAULT, msg);
    }

    public static void log(int l, String msg){
        LogLevel level = LogLevel.getByID(l);
        assert level != null;
        log(level, msg);
    }

    public static void log(LogLevel level, String msg){
        if(level == LogLevel.ERROR){
            System.out.println(level.getPrintColor() + msg + SystemColor.RESET);
            Bukkit.getServer().shutdown();
        }else{
            System.out.println(level.getPrintColor() + msg + SystemColor.RESET);
        }
    }

}
