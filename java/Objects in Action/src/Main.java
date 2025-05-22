public class Main
{
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        rectangle.length = 4.4;
        rectangle.width = 4.4;
        System.out.println("Length of rectangle is  " + rectangle.length + " Width is  " + rectangle.width);

        Employee employee = new Employee();
        employee.name = "John Doe";
        employee.id = 130;
        employee.salary = 122.36;
        System.out.println("Name of employee is = " + employee.name + " ,Id is = " + employee.id + " ,Salary is = " + employee.salary);

        Circle circle = new Circle();
        circle.radius = 3.1416;
        System.out.println("Radius of the circle is  " + circle.radius );

        Car car = new Car();
        car.brand = " kwk ";
        car.model = " aline ";
        car.year = 2009;
        System.out.println("Brand name is "+ car.brand + " Model name is "+ car.model + " Year " + car.year);

        Student student = new Student();
        student.name = " Nazmul ";
        student.id = 130;
        student.program = " BSC in CSE ";
        student.batch = 64;
        System.out.println("Name of the student is " + student.name + " Id Is " + student.id + " Program is " + student.program + " Batch is " + student.batch );


    }
}