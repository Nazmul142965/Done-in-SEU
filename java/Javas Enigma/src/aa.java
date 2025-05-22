import java.util.Scanner;

public class aa {
    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
        System.out.println("Enter a temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();
        double celsius = (fahrenheit * 32) * 5 / 9;
        System.out.println("Temperature in Celsius: " + celsius);

    }
}
