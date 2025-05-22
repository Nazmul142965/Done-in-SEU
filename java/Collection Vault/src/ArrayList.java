import java.util.List;

public class ArrayList
{
    public static void main (String[] args)
    {
        List<Integer> numberList = new java.util.ArrayList<>();

        for(int i = 0; i < 10; i++){
            numberList.add(i);
        }
        System.out.println("Populaation: " + numberList);
        System.out.println("Sum of all number: "+ calculateSum(numberList));
        System.out.println("Maximum Value: " + findMax(numberList));
        System.out.println("Minimum Value: " + findMin(numberList));
        System.out.println("Average Value: " +findAverage(numberList));

    }

    static int calculateSum(List<Integer> numberList){
        int sum = 0;
        for(int n: numberList){
            sum += n;
        }
        return sum;
    }

    static int findMax(List<Integer> numberList){
        int max = numberList.get(0);
        for(int n : numberList){
            if(n > max){
                max = n;
            }
        }
        return max;
    }
    static int findMin(List<Integer> numberList) {
        int min = numberList.get(0);
        for (int n : numberList) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }

    static double findAverage(List<Integer> numberList){
        int sum = calculateSum(numberList);
        return (double) sum / numberList.size();
    }
}



