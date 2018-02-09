package PublicUtils.log;

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

    private String CONSOLE_PREFIX = SystemColor.GREEN + "[" + SystemColor.LIME + "PublicUtils" + SystemColor.GREEN + "]" + SystemColor.RESET;

    public static void log(String msg){
        log(LogLevel.DEFAULT, msg);
    }

    public static void log(int l, String msg){
        LogLevel level = LogLevel.getByID(l);
        assert level != null;
        log(level, msg);
    }

    public static void log(LogLevel level, String msg){
        log(level, msg, false);
    }

    public static void log(LogLevel level, String msg, boolean shutdownOnError){
        if(level == LogLevel.ERROR && shutdownOnError){
            System.out.println(level.getPrintColor() + msg + SystemColor.RESET);
            Bukkit.getServer().shutdown();
        }else{
            System.out.println(level.getPrintColor() + msg + SystemColor.RESET);
        }
    }

    public static void inform(String msg){
        log(LogLevel.INFO, msg);
    }

    public static void debug(String msg){
        log(LogLevel.DEBUG, msg);
    }

    public static void warn(String msg){
        log(LogLevel.WARN, msg);
    }

    public static void throwError(String msg, boolean shutdown){
        log(LogLevel.ERROR, msg);
    }

    public static void trace(String msg){
        log(LogLevel.TRACE, msg);
    }

}
