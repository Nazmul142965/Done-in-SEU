import java.util.Scanner;

public class A2_2
{
    public static void main(String[] args)
    {
        Scanner input =  new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name = input.nextLine();

        System.out.println("Enter your birthday year: ");
        int year = input.nextInt();
        int currentYear = 2025;
        int age = currentYear - year;

        System.out.println("Hello,"+ name + "!your birth year is " + year + " and you are " + age + "years old.");
    }
}
