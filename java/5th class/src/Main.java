public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        s1.id = 130;
        s1.name = "Nazmul";
        s1.cgpa = 3.5;

        System.out.println(s1.id + " " + s1.name + " " + s1.cgpa );

        Student s2 = new Student();
        s2.name ="kala";

        Mobile mobile = new Mobile();
        mobile.brand = "Samsung";
        mobile.model = "S24";
        mobile.ram = 16;
        mobile.storage = 256;
        mobile.price = 1500000.00;

        System.out.println(mobile.brand + " " + mobile.model + " " + mobile.ram + " " + mobile.storage + " " + mobile.price);


    }
}