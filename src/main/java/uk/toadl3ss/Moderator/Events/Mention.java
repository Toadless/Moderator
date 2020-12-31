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

package uk.toadl3ss.Moderator.Events;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import uk.toadl3ss.Moderator.Database.Database;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Mention extends ListenerAdapter {
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentRaw().contains("<@!" + event.getJDA().getSelfUser().getId() + ">")) {
            String[] args = event.getMessage().getContentRaw().split(" ");
            DBObject query = new BasicDBObject("id", event.getGuild().getId());
            DBCursor cursor = Database.guild.find(query);
            if (cursor.one() == null) {
                return;
            }
            if (!event.getMember().hasPermission(Permission.getFromOffset(0x00000020))) {
                return;
            }
            if (args.length < 2) {
                event.getChannel().sendMessage("Your current prefix is:" + " " + cursor.one().get("prefix")).queue();
                return;
            }
            try {
                DBObject update = new BasicDBObject("prefix", args[1]);
                update.put("id", event.getGuild().getId());
                Database.guild.update(query, update);
                event.getChannel().sendMessage("Successfully set this guilds prefix to" + " " + args[1]).queue();
            } catch (Error e) {
                event.getChannel().sendMessage("An error occured.").queue();
                return;
            }
        }
    }
}