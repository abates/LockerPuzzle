import java.io.Console;
import java.util.StringJoiner;

public class Puzzle {
   public static void main(String []argv) {
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
         } 
         catch (NumberFormatException ex) {
            console.printf("%s is not a number\n", v);
         }
      }
      
      Hallway hallway = new Hallway(numStudents);
      StudentBody students = new StudentBody(numStudents);
      students.toggleLockers(hallway);
      
      StringJoiner joiner = new StringJoiner(", ");
      for (int lockerId : hallway.getOpenIds()) {
         joiner.add(""+lockerId);
      }
      console.printf("The following lockers are open: %s\n", joiner.toString());
   }
}