import java.util.Scanner;

public class A2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter Your age: ");
        int age = input.nextInt();

        System.out.println("Enter your height: ");
        double height = input.nextDouble();

        System.out.println("Hello, "+ name + "!You are " + age + " years old and your height is "+ height + " feet");
    }
}
