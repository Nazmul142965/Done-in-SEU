import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] x = {5, 6, 7};
        System.out.println(x[2]);

        String[] nameArray = {"Nazmul", "Jesan", "Raufur"};

        List<String> nameList = new ArrayList<>();
        nameList.add("Himel");
        nameList.add("Nazmul");
        System.out.println(nameList.get(0));

        Integer i = 3;


        List<Double> cgpaList = new ArrayList<>();
        cgpaList.add(3.0);
        cgpaList.add(4.0);
        System.out.println(cgpaList.get(1));


    }
}