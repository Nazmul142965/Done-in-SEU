import java.util.Map;

public class HashMap {
    public static void main (String[] args)
    {
        Map<Integer, Double> employeeDate = new java.util.HashMap<>();
        employeeDate.put(1, 10000.0);
        employeeDate.put(2, 20000.0);
        employeeDate.put(3, 30000.0);
        employeeDate.put(4, 40000.0);
        employeeDate.put(5, 90000.0);

        System.out.println("Employee Date : ");
        for(Map.Entry<Integer, Double> entry : employeeDate.entrySet()){
            System.out.println("Enter Id: " + entry.getKey() + "Enter the value : " + entry.getValue());
        }

        double averageSalary = calculateAverageSalary(employeeDate);
        System.out.println("Average Salary : " + averageSalary);

    }
    static double calculateAverageSalary(Map<Integer, Double> employeeDate){
        double sum =  0;
        for(double employeeSalary : employeeDate.values()){
            sum += employeeSalary;
        }
        return sum / employeeDate.size();
    }
}
