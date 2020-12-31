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

package uk.toadl3ss.Moderator.Database;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import uk.toadl3ss.Moderator.Utils.Config;

public class Database {
    public static MongoClient mongoClient;
    public static DBCollection guild;
    public static DBCollection user;
    public static DB database;
    public static void main() {
        mongoClient = new MongoClient(new MongoClientURI(Config.INS.getDatabase()));
        database = mongoClient.getDB("Moderator");
        guild = database.getCollection("guilds");
        user = database.getCollection("users");
    }
}
