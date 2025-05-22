import java.util.Scanner;

public class A1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter two integers: ");
        int a = input.nextInt();
        int b = input.nextInt();

        int sum = a + b;
        System.out.println("The sum is " + sum);
        int difference = a - b;
        System.out.println("The difference is " + difference);
        int mult = a * b;
        System.out.println("The multipication is " + mult);
        if(b != 0){
            int quotient = a / b;
            System.out.println("The quotient is " + quotient);
        }else{
            System.out.println("It Can't divide by zero");
        }
    }
}
