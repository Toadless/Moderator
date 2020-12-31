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

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDate {
    private static final String pattern = "Y-M-D HH:mm:ss.SSS";
    private static final SimpleDateFormat patternFormat = new SimpleDateFormat(pattern);
    public static final String dte = patternFormat.format(new Date());
    public static final String date = (dte + " " + "INFO -- [" + " ");
}
