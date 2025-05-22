import java.util.Scanner;

public class A5
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner (System.in);

        System.out.println("Enter the Three Numbers : ");

        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int num3 = input.nextInt();

        if(num1 >= num2 && num1 >= num3){
            System.out.println("Number 1 is largest " + num1);
        }else if (num2 >= num3 && num2 >= num1) {
            System.out.println("Number 2 is largest " + num2);
        }else if (num3 >= num1 && num3 >= num2){
            System.out.println("Number 3 is largest " + num3);
         }
    }
}
