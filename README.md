<h1 align="center">
  <img width="750" src="https://image.ibb.co/nHgsrH/Public_Utilities2.png" alt="Public_Utilities" border="0">
  <br>
  <br>
</h1>

## Utilities
- [System Color](#system-color)
- [Bukkit File System](#bukkit-files)
- [Logging System](#logger)

## System Color
- [SystemColor.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/SystemColor.java) - SystemColor is an enumerator that contains strings for different
color codes for use in the console.  This helps to identify errors and debugging messages.
    - <em><strong>SystemColor.RESET</strong></em> - Reset the console back to its original color.
    - <em><strong>SystemColor.BLACK</strong></em> - Change the color of console chat to 'black'. <sub>(0,0,0)</sub>
    - <em><strong>SystemColor.GRAY</strong></em> - Change the color of console text to 'bright black'. <sub>(128,128,128)</sub>
    - <em><strong>SystemColor.MAROON</strong></em> - Change the color of console chat to 'red'. <sub>(128,0,0)</sub>
    - <em><strong>SystemColor.RED</strong></em> - Change the color of console text to 'bright red'. <sub>(255,0,0)</sub>
    - <em><strong>SystemColor.GREEN</strong></em> - Change the color of console chat to 'green'. <sub>(0,128,0)</sub>
    - <em><strong>SystemColor.LIME</strong></em> - Change the color of console text to 'bright green'. <sub>(0,255,0)</sub>
    - <em><strong>SystemColor.GOLD</strong></em> - Change the color of console chat to 'yellow'. <sub>(128,128,0)</sub>
    - <em><strong>SystemColor.YELLOW</strong></em> - Change the color of console text to 'bright yellow'. <sub>(255,255,0)</sub>
    - <em><strong>SystemColor.BLUE</strong></em> - Change the color of console chat to 'blue'. <sub>(0,0,128)</sub>
    - <em><strong>SystemColor.ROYAL</strong></em> - Change the color of console text to 'bright blue'. <sub>(0,0,255)</sub>
    - <em><strong>SystemColor.PURPLE</strong></em> - Change the color of console chat to 'magenta'. <sub>(128,0,128)</sub>
    - <em><strong>SystemColor.MAGENTA</strong></em> - Change the color of console text to 'bright magenta'. <sub>(255,0,255)</sub>
    - <em><strong>SystemColor.AQUAMARINE</strong></em> - Change the color of console chat to 'cyan'. <sub>(0,128,128)</sub>
    - <em><strong>SystemColor.CYAN</strong></em> - Change the color of console text to 'bright cyan'. <sub>(0,255,255)</sub>
    - <em><strong>SystemColor.SILVER</strong></em> - Change the color of console chat to 'white'. <sub>(192,192,192)</sub>
    - <em><strong>SystemColor.WHITE</strong></em> - Change the color of console text to 'bright white'. <sub>(255,255,255)</sub>

## Bukkit Files
- [BukkitFile.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/BukkitFile.java) - BukkitFiles has always been my go to for easy file creation
and management, this class allows the easy creation of files and folders, as well as easily edit existing files.

## Logger
- [LogUtil.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/log/LogUtil.java) - LogUtil allows you to easily log information to the console,
as well as it uses [SystemColor](#system-color) to automatically set the color (as well as reset it, which is one of the more useful capabilities).  It also checks if the program
is logging an error, and if it is, the logger will perform an emergency shutdown (this helps with keeping the logs clear, so you can easily locate the error).
- [LogLevel.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/log/LogLevel.java) - LogLevel is an enumerator that contains multiple different logging levels.
    - <em><strong>LogLevel.DEFAULT</strong></em> - Outputs in silver, best used for unimportant logs.
    - <em><strong>LogLevel.INFO</strong></em> - Outputs in lime, best used for logs that are important, but not critical.
    - <em><strong>LogLevel.DEBUG</strong></em> - Outputs in aquamarine, used for debugging code.
    - <em><strong>LogLevel.WARN</strong></em> - Outputs in gold, used for critical issues, but will not perform an emergency shutdown.
    - <em><strong>LogLevel.ERROR</strong></em> - Outputs in red, used for project-breaking errors, performs an emergency shutdown upon logging.
    - <em><strong>LogLevel.TRACE</strong></em> - Outputs in magenta, best used in conjunction with debug, for minute details.

<h2 align="center">My Social Media Links</h2>
<p align="center">
  <a href="http://bit.ly/TwitterBigBear" class="fa-stack fa-lg"><img width="120" src="https://image.ibb.co/j19iWH/Twitter.png" alt="Twitter" border="0"></a>&nbsp;&nbsp;&nbsp;
  <a href="http://bit.ly/GitHubBigBear" class="fa-stack fa-lg"><img width="120" src="https://image.ibb.co/fwmVBH/GitHub.png" alt="GitHub" border="0"></a>&nbsp;&nbsp;&nbsp;
  <a href="http://bit.ly/BigBearCoding" class="fa-stack fa-lg"><img width="120" src="https://image.ibb.co/j0NRkc/Youtubwe.png" alt="YouTube" border="0"></a>&nbsp;&nbsp;&nbsp;
  <a href="http://bit.ly/SpigotBigBear" class="fa-stack fa-lg"><img width="120" src="https://image.ibb.co/m8TcrH/Spigot.png" alt="Spigot" border="0"></a>&nbsp;&nbsp;&nbsp;
  <a href="http://bit.ly/TwitterBigMike" class="fa-stack fa-lg"><img width="120" src="https://image.ibb.co/j19iWH/Twitter.png" alt="Twitter2" border="0"></a>
</p>

<h3 align="center">
  <a href="http://bit.ly/BigBearCoding" class="fa-stack fa-lg"><img width="600" src="https://image.ibb.co/gBowJx/Website_Icon.png" alt="Visit my Website" border="0"></a>
  <br>
  <br>
</h3>

<h4 align="center">Connect with Me</h4>
<p align="center">
  <a href="https://discord.gg/pDCQw6d" class="fa-stack fa-lg"><img width="120" src="https://image.ibb.co/gLtoyx/Discord.png" alt="Discord" border="0"></a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href=”https://join.skype.com/ve7Dqllutyge″><img width="120" src="https://image.ibb.co/fhtABH/Skype.png" alt="Skype" border="0"></a>
</p>


