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

import java.util.Date;

public class Info {
    public static void Info(String version) {
        String Version = version;
        String JavaVerson = System.getProperty("java.version");
        int Cores = Runtime.getRuntime().availableProcessors();
        Date startTime = new Date();
        System.out.println("                        Version:        " + Version);
        System.out.println("                        JavaVersion:    " + JavaVerson);
        System.out.println("                        Cores:          " + Cores);
        System.out.println("                        StartTime:      " + startTime);
        System.out.println(" ");
    }
}
