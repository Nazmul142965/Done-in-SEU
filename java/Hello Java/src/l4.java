import java.util.Scanner;

public class l4
{
    /*public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double cgpa = sc.nextDouble();

        //String value ="Your CGPA is " + cgpa;

        if(cgpa > 3) {
            System.out.println("Good luck. Yur CGPA is " +cgpa);
        }else if (cgpa > 2){
            System.out.println("Good. Your CGPa is " +cgpa);
        }else {
            System.out.println("Try again. Your CGPa is " +cgpa);
        }


    }
}*/

/*{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        /*String name = scanner.nextLine();

        //toLowerCase
        //equalIgnoreCase?
        if(name.toLowerCase().equals("jane"))
        {
            System.out.println("You are jane ");
        }else{
            System.out.println("You are unknown");
        }

        switch(name)
        {
            Case "Jone";
            {
                System.out.println("Your are Jone");
                break;
            }
            case "Jack":{
                System.out.println("Your are Jack");
                break;
            }
        }*/

       /* for(int i = 1; i <= 10 ;i++)
        {
            System.out.println(i + " Thank You");
        }*/

        public static void main(String[] args)
        {
                int sum = sumofNumber(5, 2);
                double sum2 = sumof2Numbers(5.5, 2);
                double sum3 = sumof3Number(5.5, 2, 3);

                System.out.println(sum + sum2 + sum3);

        }
            static int sumofNumber(int x, int y){
                return  x + y;
        }
        static double sumof2Numbers(double x, int y){
                return x + y;
        }
        static double sumof3Number(double x, double y, double z){
                return x + y + z;
        }

}


