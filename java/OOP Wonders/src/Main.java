public class Main {
    public static void main(String[] args)
    {
        Student s1 = new Student();
        s1.setName("Nazmul");
        s1.setRoll(130);
        s1.setProgram("CSE");
        System.out.println(s1.getName() + " " + s1.getRoll() + " " + s1.getProgram());

        Student s2 = new Student("Bijoy", 84, "CSE", 64);
        System.out.println(s2.getName() + " " + s2.getRoll() + " " + s2.getProgram() + " " + s2.getBatch());

        Student s3 = new Student("Lijon", 153, "CSE", 64);
        System.out.println(s3.getName() + " " + s3.getRoll() + " " + s3.getProgram() + " " + s3.getBatch());


        Car c1 = new Car();
        c1.setBrand("Honda");
        c1.setModel("Civic");
        c1.setYear(2020);
        System.out.println(c1.getBrand() + " " + c1.getModel() + " " + c1.getYear());

        Car c2 = new Car("Tesla", "Tesla", 2024, "Black");
        System.out.println(c2.getBrand() + " " + c2.getModel() + " " + c2.getYear() + " " + c2.getColor());

        Car c3 = new Car("MG", "Haval", 2006, "Black");
        System.out.println(c3.getBrand() + " " + c3.getModel() + " " + c3.getYear() + " " + c3.getColor());

        Employee e1 = new Employee();
        e1.setName("Nazmul");
        e1.setId(130);
        e1.setSalary(2000.99);
        System.out.println(e1.getName() + " " + e1.getId() + " " + e1.getSalary());

        Employee e2 = new Employee("Bijoy", 84, 22, 2229.22);
        System.out.println(e2.getName() + " " + e2.getId() + " " + e2.getAge() +" " + e2.getSalary());

        Employee e3 = new Employee("Rumi", 54, 33, 14400.55);
        System.out.println(e3.getName() + " " + e3.getId() +" " + e3.getAge() +" " + e3.getSalary());

    }
}
