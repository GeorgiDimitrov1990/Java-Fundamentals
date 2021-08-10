import java.util.Scanner;

public class Demo5 {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[] numbers = new int[] { 1, 2, 3, 4, 5};

    String [] numAsStrings = new String[numbers.length];
    for (int i = 0; i < numAsStrings.length ; i++) {
        numAsStrings[i] = String.valueOf(numbers[i]);
    }
    String s = String.join("  ", numAsStrings);
    System.out.println(s);
}
}
