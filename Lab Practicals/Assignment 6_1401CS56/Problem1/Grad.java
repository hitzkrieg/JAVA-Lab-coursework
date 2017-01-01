public class Grad extends Student
{
   Grad(String name,    String id,  double grade,  int age, String address) 
   {
       super(name, id, grade, age, address);
       
   }
   
   public boolean isPassed(double grade)
   {
       if (grade>80)
       {
           return(true);
       }
       else
           return(false);
   }

}