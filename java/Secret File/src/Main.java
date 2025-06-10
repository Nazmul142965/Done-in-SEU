import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if(authenticateOfficer(scanner)) {
            displayMenu();
        }else{
            System.out.println("Autentication  failed!");
        }
    }
    private static boolean authenticateOfficer(Scanner scanner){
        System.out.println("Welcome to Student Management System ");

        while(true){
            System.out.print("Enter your Username: ");
            String username = scanner.nextLine();
            System.out.print("Enter your Password: ");
            String password = scanner.nextLine();

            try{
                RandomAccessFile rf = new RandomAccessFile("secret.txt", "rw");
                rf.setLength(0);
                rf.writeBytes("Nazmul,1234");

                File file = new File("secret.txt");
                Scanner fileReader = new Scanner(file);

                while (fileReader.hasNextLine()) {
                    String line = fileReader.nextLine();
                    String[] parts = line.split(",");
                    if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                        System.out.println("Successfully authenticated.");
                        fileReader.close();
                        return true;
                    }
                }
                fileReader.close();
                System.out.println("Invalid username or password. Try again.");
            }catch (IOException ex) {
                System.out.println("File Error");
                ex.printStackTrace();
            }
        }

    }
    private static void displayMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n---Student Management System---\n");
            System.out.println("1. Add Student Information ");
            System.out.println("2. view Student Information ");
            System.out.println("3. Add Advised Courses ");
            System.out.println("4. view Advised Courses ");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent(scanner);
                    break;
                case 2:  viewStudent(scanner);
                break;
                case 3: addAdvisedCourse(scanner);
                break;
                case 4: viewAdvisedCourse(scanner);
                break;
                case 5:
                    System.err.println(" END! ");
                    return;
                default:
                    System.err.println("Invalid choice");

            }
        }while (choice != 5);
    }

    static void addStudent(Scanner scanner) {
        try{
        System.out.println("Enter Student ID: ");
        String studentID = scanner.nextLine();
        System.out.println("Enter Password: ");
        String password = scanner.nextLine();
        System.out.println("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter Program: ");
        String program = scanner.nextLine();
        System.out.println("Enter Batch: ");
        String batch = scanner.nextLine();
        System.out.println("Enter CGPA: ");
        String cgpa = scanner.nextLine();

        FileWriter fw = new FileWriter("student.txt", true);
        fw.write(studentID + " , " + password + " , " + studentName + " , " + program + " , " + batch + " , " + cgpa + "\n");
        fw.close();

        System.out.println("Student Added Successfully");
    }catch(IOException ex)
    {
        System.err.println("File not found");
    }
    }
    static void viewStudent(Scanner scanner){
        try{
            File file = new File("student.txt");
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()){
                String line = reader.nextLine();
                System.out.println(line);
            }
            reader.close();
        }catch (IOException ex){
            System.err.println("File not found");
        }
    }

    static void addAdvisedCourse(Scanner scanner){
        try {
            System.out.println("Enter Student ID: ");
            String studentID = scanner.nextLine();
            System.out.println("Enter your desire course code: ");
            String courseCode = scanner.nextLine();

            FileWriter fw = new FileWriter("AddCourse.txt", true);
            fw.write(studentID + "," + courseCode);
            fw.close();

            System.out.println("Couse Added Successfully");
        }catch (IOException ex){
            System.err.println("File not found");
        }
    }

    static void viewAdvisedCourse(Scanner scanner){
        try {
            System.out.println("Enter Student ID: ");
            String searchID = scanner.nextLine();

            File file = new File("AddCourse.txt");
            Scanner reader = new Scanner(file);
            boolean found = false;

            while(reader.hasNextLine()){
                String line = reader.nextLine();
                String[] parts = line.split(",");
                if(parts[0].equals (searchID)){
                    System.out.println( "Course " + parts[1]);
                    found = true;
                    break;
                }
            }

            if(!found){
                System.err.println("Student Not Found");
            }
            reader.close();
        }catch (IOException ex){
            System.err.println("File not found");
        }
    }
}