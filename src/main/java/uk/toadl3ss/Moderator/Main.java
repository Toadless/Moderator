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

import uk.toadl3ss.Moderator.Database.Database;
import uk.toadl3ss.Moderator.Utils.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.Compression;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Main {
    public static String version = "1.0";
    public static void main(String[] args) throws LoginException, IOException {
        Vanity.printVainity();
        Info.Info(version);
        Config.init("config.yml");
        Database.main();
        JDABuilder builder = JDABuilder.createDefault(
                Config.INS.getBotToken(),
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_BANS,
                GatewayIntent.GUILD_EMOJIS,
                GatewayIntent.GUILD_INVITES,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_MESSAGE_TYPING,
                GatewayIntent.GUILD_WEBHOOKS
        );
        builder.disableCache(
                CacheFlag.MEMBER_OVERRIDES,
                CacheFlag.VOICE_STATE
        );
        EventListeners.addEventListeners(builder);
        builder.setBulkDeleteSplittingEnabled(false);
        builder.setCompression(Compression.NONE);
        builder.setActivity(Activity.streaming("Development", "https://twitch.tv/toadless"));
        builder.build();
    }
}
