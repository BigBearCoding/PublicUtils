<h1 align="center">
  <img width="750" src="https://image.ibb.co/igUUYx/Public_Utlilies.png" alt="Public_Utilities" border="0">
  <br>
  <br>
</h1>

## Utilities
- [Bukkit File System](#bukkit-files)
- [Logging System](#logger)
- [ChatUtil](#chat-util)
- [Menu System](#menu-builder)

## Bukkit Files
- [SimpleFile.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/files/SimpleFile.java) - I changed a few things on the Bukkit Files system. One of the things
I always wanted to have as a capability in my system was the have a commenting system.  I [found an old public system](https://bukkit.org/threads/tut-custom-yaml-configurations-with-comments.142592/)
that had commenting abilities.  I tweaked quite a few things to fit my file system and I compressed it into one easy to use class.

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
- [SystemColor.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/log/SystemColor.java) - SystemColor is an enumerator that contains strings for different
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

## Chat Util
- [ChatUtil.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/chat/ChatUtil.java) - ChatUtil is made just to make sending messages a tiny bit easier,
not much to it other than allowing you to send messages and not have to worry about color code correction etc
- [Lang.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/chat/Lang.java) - Instead of trying to explain this let me just write out an example. Say
you are trying to make an 'arena created' message, you would want your object to look something like this...
<strong>ARENA_CREATED</strong>(<em>"arena-create"</em> [this is the file path that the text is saved to], <em>"You successfully created arena: $arena"</em> [this is the default
message that is sent if another isn't found.], <em>PlaceholderText.ARENA</em> [your placeholder object]);
- [PlaceholderText.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/chat/PlaceholderText.java) - Going off of the same example from above,
inside your PlaceholderText class you would want...
<strong>ARENA</strong>(<em>"$arena"</em> [this is what will be replaced inside your messages, <em>"Replaces with your arenas name"</em> [this is what the description will be in your file]);
With both of those made, to create a string for message sending simply call, Lang.ARENA_CREATED.replace(new String[]{}, new String[]{}) the arrays can be as long as you like and will search
and replace the equivalent. (So if you have 4 in each, the 4th placeholder will be replaced with the 4th string to replace it with)

## Menu Builder
- [Menu.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/menu/Menu.java) - This menu builder was something a good friend of mine [Sky](https://twitter.com/sky8the2flies) made pretty much totally on his own while we made
the original KOTH a few years back!  This util is meant to mainly.... blah blah blah, I'll do this later... tbh nobody is probably gonna see this anyways :D
- [MenuAPI.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/menu/MenuAPI.java) - bklah blah blah
- [MenuItem.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/menu/MenuItem.java) - blah blah blah
- [MenuCloseBehavior.java](https://github.com/BigBearCoding/PublicUtils/blob/master/src/main/java/PublicUtils/menu/MenuCloseBehavior.java) - blagh bklag bkag

## Official Updates
- 1.0.0 (2/4/18):
    - Initial push
- 1.0.2 (2/6/18):
    - Changed BukkitFile to [BFile](#bukkit-files) for no REAL reason, it just makes it easier on myself to import rather than my IDE trying to import Bukkit.java
    - Added methods such as 'warn' and 'inform' to [LogUtil.java](#logger) to make tedious logging easier (such as excessive use of warning and what not)
- 1.1.0 (2/8/18):
    - Made it so my filing system has the ability to add comments and headers.
    - Merged [SystemColor and LogUtil](#logger)
- 1.2.0 (2/9/18):
    - Created a chat util
    - Created lang system and placeholder system, its separate because the place holder system actually becomes useful in my future score board util, so I figured just make the class public and on its own for cleanliness
- 1.3.0 (2/9/18):
    - Just moved Sky's Menu util into the here for KOTH work

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
  <a href="http://bit.ly/BigBearSkype" class="fa-stack fa-lg"><img width="120" src="https://image.ibb.co/fhtABH/Skype.png" alt="Skype" border="0"></a>
</p>
