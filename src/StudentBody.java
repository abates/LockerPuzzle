
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

public class StudentBody {
    private Student[] students;

    public StudentBody(int numStudents) {
        students = new Student[numStudents];
        for (int studentId = 1; studentId <= numStudents; studentId++) {
            // array indices start at zero, but we don't
            // want a student ID of zero. that's why the
            // loop index starts at one and then we subtract
            // when using the studentId as an array index :)
            students[studentId - 1] = new Student(studentId);
        }
    }

    public void toggleLockers(Hallway hallway) {
        for (Student student : students) {
            student.toggleLockers(hallway);
        }
    }
}