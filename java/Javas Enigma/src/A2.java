import java.util.Scanner;

public class A2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = input.nextLine();
        s = s.toLowerCase();

        int vowels = 0;
        int consonants = 0;

        for(int i = 0; i < s.length(); i++ )
        {
            if((s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) =='o')|| s.charAt(i) == 'u' ){
                vowels++;
            }else{
                consonants++;
            }
        }
        System.out.println("The vowels are " + vowels);
        System.out.println("The consonants are " + consonants);
    }
}
