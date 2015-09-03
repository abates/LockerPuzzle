
/**
 * Copyright 2015 Andrew Bates
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import java.io.Console;
import java.util.StringJoiner;

public class Puzzle {
    public static void main(String[] argv) {
        Console console = System.console();
        int numStudents = 0;
        while (numStudents <= 0) {
            console.printf("Number of students and lockers: ");
            String v = console.readLine();
            try {
                numStudents = Integer.parseInt(v);
                if (numStudents <= 0) {
                    console.printf("The number of students and lockers must be greater than zero\n");
                }
            } catch (NumberFormatException ex) {
                console.printf("%s is not a number\n", v);
            }
        }

        Hallway hallway = new Hallway(numStudents);
        StudentBody students = new StudentBody(numStudents);
        students.toggleLockers(hallway);

        StringJoiner joiner = new StringJoiner(", ");
        for (int lockerId : hallway.getOpenIds()) {
            joiner.add("" + lockerId);
        }
        console.printf("The following lockers are open: %s\n", joiner.toString());
    }
}