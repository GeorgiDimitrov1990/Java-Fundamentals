import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < numbers.length / 2  ; i++) {

            int swapIndex = numbers.length - 1 - i;
            int oldNumbers = numbers[i];
            numbers[i] = numbers[swapIndex];
            numbers[swapIndex] = oldNumbers;
        }
        for (int i = 0; i < numbers.length ; i++) {
            System.out.println(numbers[i] + " ");
        }
    }
}
