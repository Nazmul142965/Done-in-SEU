public class Employee
{
    private String name;
    private int id;
    private int age;
    private double salary;

    Employee(){

    }
    Employee(String givenName, int givenId,  double givenSalary){
        name = givenName;
        id = givenId ;
        salary = givenSalary ;
    }
    Employee(String name, int id, int age, double salary){
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
    }
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    void setId(int id){
        this.id = id;
    }
    int getId(){
        return id;
    }
    void setAge(int age){
        this.age = age;
    }
    int getAge(){
        return age;
    }
    void setSalary(double salary){
        this.salary = salary;
    }
    double getSalary(){
        return salary;
    }
}
