public class StudentBody {
   private Student[] students;
   
   public StudentBody(int numStudents) {
      students = new Student[numStudents];
      for (int studentId = 1; studentId <= numStudents; studentId++) {
         // array indices start at zero, but we don't
         // want a student ID of zero.  that's why the
         // loop index starts at one and then we subtract
         // when using the studentId as an array index :)
         students[studentId-1] = new Student(studentId);
      }
   }
   
   public void toggleLockers(Hallway hallway) {
      for (Student student : students) {
         student.toggleLockers(hallway);
      }
   }
}