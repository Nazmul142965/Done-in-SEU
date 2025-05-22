import java.util.Set;

public class HashSet
{
    public static void main(String[] args)
    {
        Set<String> countrySet = new java.util.HashSet<>();
        countrySet.add("USA");
        countrySet.add("Bangladesh");
        countrySet.add("Finlands");
        countrySet.add("France");
        countrySet.add("Japan");

        for(String countryName : countrySet){
            System.out.println(countryName);
        }
    }

}
