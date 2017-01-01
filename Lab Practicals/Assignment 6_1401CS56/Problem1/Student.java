
public abstract class Student
{
    String name;
    String id;
    double grade;
    int age;
    String address;
    
    Student(String name,    String id,  double grade,  int age, String address)
    {
        this.name =  name;
        this.id= id;
        this.grade= grade;
        this.age= age;
        this.address= address;
    }
 
    public abstract boolean isPassed(double grade);   
}

