public class Student {
   private int id;
   
   public Student(int id) {
      this.id = id;
   }
   
   public void toggleLockers(Hallway hallway) {
      for (Locker locker : hallway) {
         if (locker.getId() % id == 0) {
            locker.toggle();
         }
      }
   }
}