/*  Copyright 2020 Toadless @ toadl3ss.uk
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * */

package uk.toadl3ss.Moderator;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import uk.toadl3ss.Moderator.Commands.*;
import uk.toadl3ss.Moderator.Commands.Owner.Shutdown;
import uk.toadl3ss.Moderator.Commands.Warn;
import uk.toadl3ss.Moderator.Database.Database;

public class CommandHandler extends ListenerAdapter {
    /*
    *
    * We have a commandHandler so that we arnt making
    * thousands of requests to the MongoDB Database.
    *
    * */
    public void onMessageReceived(MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split(" ");
        DBObject query = new BasicDBObject("id", event.getGuild().getId());
        DBCursor cursor = Database.guild.find(query);
        String prefix = (String) cursor.one().get("prefix");
        if (cursor.one() == null) {
            return;
        }

        //Ban command
        if (args[0].equalsIgnoreCase(prefix + "ban")) {
            Ban.banCommand(event, args);
            return;
        }
        //Prefix command
        if (args[0].equalsIgnoreCase(prefix + "prefix")) {
            Prefix.prefixCommand(event, args, query, cursor);
            return;
        }
        //Kick command
        if (args[0].equalsIgnoreCase(prefix + "kick")) {
            Kick.kickCommand(event, args);
            return;
        }
        //Clear command
        if (args[0].equalsIgnoreCase(prefix + "clear")) {
            Clear.clearCommand(event, args);
            return;
        }
        //Eight ball command
        if (args[0].equalsIgnoreCase(prefix + "8ball")) {
            EightBall.eightballCommand(event, args, cursor);
            return;
        }
        //Invite command
        if (args[0].equalsIgnoreCase(prefix + "invite")) {
            Invite.inviteCommand(event, args);
            return;
        }
        //Uptime command
        if (args[0].equalsIgnoreCase(prefix + "uptime")) {
            Uptime.uptimeCommand(event, args);
            return;
        }
        //Avatar command
        if (args[0].equalsIgnoreCase(prefix + "avatar")) {
            Avatar.avatarCommand(event, args);
            return;
        }
        //Bot invite command
        if (args[0].equalsIgnoreCase(prefix + "botinvite")) {
            BotInvite.botinviteCommand(event, args);
            return;
        }
        //Bot info command
        if (args[0].equalsIgnoreCase(prefix + "info")) {
            Info.infoCommand(event, args);
            return;
        }
        //warn command
        if (args[0].equalsIgnoreCase(prefix + "warn")) {
            Warn.warnCommand(event, args);
            return;
        }
        //help command
        if (args[0].equalsIgnoreCase(prefix + "help")) {
            Help.helpCommand(event, args);
            return;
        }


        //Shutdown command
        if (args[0].equalsIgnoreCase(prefix + "shutdown")) {
            Shutdown.shutdownCommand(event, args);
            return;
        }
    }
}