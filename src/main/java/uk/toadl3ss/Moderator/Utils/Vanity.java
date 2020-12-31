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

public class Vanity {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    public static void printVainity() {
        String vanity = "       g.r     __  __           _                _             g _ _ _ \n" +
                "g       /\\\\ r |  \\/  |         | |              | |            g\\ \\ \\ \\\n" +
                "g      ( ( ) r| \\  / | ___   __| | ___ _ __ __ _| |_ ___  _ __  g\\ \\ \\ \\\n" +
                "g       \\\\/  r| |\\/| |/ _ \\ / _` |/ _ \\ '__/ _` | __/ _ \\| '__|  g) ) ) )\n" +
                "g        '   r| |  | | (_) | (_| |  __/ | | (_| | || (_) | |    g/ / / /\n" +
                "g            r|_|  |_|\\___/ \\__,_|\\___|_|  \\__,_|\\__\\___/|_|   g/_/_/_/ \n" +
                "   d=================================================================";
        String green = vanity.replace("g", ANSI_GREEN);
        String red = green.replace("r", ANSI_RED);
        String VanityFinish = red.replace("d", ANSI_RESET);
        System.out.println(VanityFinish);
    }
}