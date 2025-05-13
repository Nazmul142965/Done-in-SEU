import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("What is your student id?");

        Scanner input = new Scanner(System.in);
        int id = input.nextInt();

        System.out.println("Your id is " + id +". Welcome");
        System.out.println("What is your CGPA?");
        double cgpa = input.nextDouble();
        System.out.println("Your CGPA is " + cgpa );

        System.out.println("What is your name?");
        String studentName = input.next();
        System.out.println("Your student name is " + studentName);
    }
}