import java.util.Arrays;
import java.util.Scanner;

public class Е7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        int index = 0;
        int realCounter = 0;

        for (int i = 0; i < numbers.length ; i++) {
            int counter = 1;
            int currentNum = numbers[i];

            for (int j = i + 1; j < numbers.length ; j++) {
                if (currentNum == numbers[j]){
                    counter++;
                } else {
                    break;
                }
            }
            if (counter > realCounter){
                realCounter = counter;
                index = currentNum;
            }
        }
        for (int i = 0; i < realCounter ; i++) {
            System.out.print(index + " ");
        }
    }
}
