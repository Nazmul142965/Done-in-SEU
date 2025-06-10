import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Gender gender = Gender.FEMALE;

        switch(gender) {
            case MALE:
                System.out.println(Gender.MALE);
                break;
            case FEMALE:
                System.out.println(Gender.FEMALE);
                break;
        }

        double v = Math.PI * 5;
        double w = Math.PI* Math.pow(5,4);
        System.out.println(v + " : " + w);

        String dob =  " 24 April 2001";
        LocalDate date = LocalDate.of(2001, 4,24);
        LocalDate date1 = LocalDate.of(2001, Month.APRIL, 1);
        System.out.println(date.getDayOfWeek());
//        System.out.println(date.plusYears();
        System.out.println(date1);
        System.out.println(LocalDate.now());


        LocalTime time = LocalTime.of(12, 52);
        System.out.println(time);

        LocalTime time1 = LocalTime.of(12, 52, 44);
        System.out.println(time1);

        System.out.println(LocalTime.now());

        LocalDateTime dt = LocalDateTime.of(2024, 4, 5, 23, 44);
        System.out.println(dt);
        System.out.println(LocalDateTime.now());

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Bijoy Bhai", 3.56));
        studentList.add(new Student(2, "Nazmul Bhai", 3.82));
        studentList.add(new Student(3, "Lamisa Apu", 2.78));
        studentList.add(new Student(4, "Nur Apu", 2.15));
        studentList.add(new Student(5, "Nitu Apu", 3.00));

        double sum= 0;
        for(Student student : studentList) {
            sum += student.getCgpa();
        }
        System.out.println(sum);

        long count = studentList.stream().map(Student::getCgpa).count();
        System.out.println(count);
        double sum1 = studentList.stream().mapToDouble(Student::getCgpa).sum();
        System.out.println(sum1);

        double sum4 = studentList.stream().filter(s-> s.getName().endsWith("Apu") && s.getCgpa() > 2).mapToDouble(Student:: getCgpa).sum();
        System.out.println(sum4);

        double average = studentList.stream().filter(s-> s.getName().endsWith("Bhai")).mapToDouble(Student:: getCgpa).average().getAsDouble();
        System.out.println(average);
    }
}