import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<>();
        numbers.add("42");
        numbers.add("13");
        numbers.add("111");
        numbers.add("256");
        double sum = numbers.stream().mapToDouble(i -> Double.parseDouble(i)).sum();
        System.out.println(sum);
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);




        int[] numbersArray = new int[] {42, 13, 68, 111, 256};

        String[] numberAsString = new String[] {"42", "13", "68"};





    }
}
