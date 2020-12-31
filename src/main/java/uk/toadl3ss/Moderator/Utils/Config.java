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

package uk.toadl3ss.Moderator.Utils;

import org.simpleyaml.configuration.file.FileConfiguration;
import org.simpleyaml.configuration.file.YamlConfiguration;
import org.simpleyaml.exceptions.InvalidConfigurationException;

import java.io.File;
import java.io.IOException;

public class Config {
    private File config;
    public static Config INS;
    public String ownerId;
    public String database;
    public String prefix;
    public String token;
    public String color;

    private Config(String file) {
        config = new File(file);
        initConfig();
    }

    public static void init(String file) {
        INS = new Config(file);
    }

    @SuppressWarnings("unchecked")
    private void initConfig() {
        FileConfiguration config = new YamlConfiguration();
        try {
            config.load(this.config);
        } catch (InvalidConfigurationException | IOException e) {
            System.out.println("Invalid yaml configuration" + e);
            return;
        }
        this.prefix = config.getString("prefix");
        this.token = config.getString("bot.token");
        this.ownerId = config.getString("bot.ownerId");
        this.database = config.getString("database");
        this.color = config.getString("color");
    }
    public String getPrefix() {
        return prefix;
    }
    public String getBotToken() {
        return token;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public String getDatabase() {
        return database;
    }
    public String getColor() {
        return color;
    }
}