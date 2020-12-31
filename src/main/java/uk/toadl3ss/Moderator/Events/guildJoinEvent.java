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
import com.mongodb.DBObject;
import uk.toadl3ss.Moderator.Database.Database;
import uk.toadl3ss.Moderator.Utils.Config;
import uk.toadl3ss.Moderator.Utils.CurrentDate;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class guildJoinEvent extends ListenerAdapter {
    public void onGuildJoin(GuildJoinEvent event) {
        try {
            DBObject guild = new BasicDBObject("id", event.getGuild().getId())
                    .append("prefix", Config.INS.getPrefix());
            Database.guild.insert(guild);
        } catch (Error e) {
            System.out.println(CurrentDate.date + "Error creating a guilds database! Error: " + e);
        }
    }
}