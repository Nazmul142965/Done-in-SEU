import java.util.Scanner;

public class A2_3
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the length of the rectangular: ");
        double length = input.nextDouble();

        System.out.println("Enter the width of he rectangular: ");
        double width = input.nextDouble();

        double area = length * width;

        System.out.println("The area of the rectangular is " + area +" square units.");
    }
}
