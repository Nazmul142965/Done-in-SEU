public class Student
{
    private String name;
    private int roll;
    private String program;
    private int batch;

    Student()
    {

    }
    Student(String givenName, int givenRoll, String  givenProgram){
        name = givenName;
        roll = givenRoll;
        program = givenProgram;

    }

    Student(String name, int roll, String program, int batch)
    {
        this.name = name;
        this.roll = roll;
        this.program = program;
        this.batch = batch;
    }

    void setName (String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    void setRoll (int roll){
        this.roll = roll;
    }
    int getRoll(){
        return roll;
    }
    void setProgram (String program){
        this.program = program;
    }
    String getProgram(){
        return program;
    }
    void setBatch (int batch){
        this.batch = batch;
    }
    int getBatch(){
        return batch;
    }
}


