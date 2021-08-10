import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        int maxLineLength = new Scanner(System.in).nextInt();

        for (int i = 1; i <= maxLineLength ; i++) {
            printNumbers(i);
        }
        for (int i = maxLineLength-1; i >= 1 ; i--) {
            printNumbers(i);
        }
    }

    private static void printNumbers(int maxNumber) {
        for (int i = 1; i <= maxNumber; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
