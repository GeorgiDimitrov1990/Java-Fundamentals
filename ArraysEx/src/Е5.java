import java.util.Arrays;
import java.util.Scanner;

public class Е5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(element -> Integer.parseInt(element)).toArray();

        for (int i = 0; i <numbers.length ; i++) {
            boolean isTopInteger = true;
            int currentNum = numbers[i];
            for (int j = i + 1; j < numbers.length ; j++) {
                if (currentNum <= numbers[j]){
                    isTopInteger = false;
                }
            }
            if (isTopInteger){
                System.out.print(currentNum + " ");
            }
        }
    }
}
