import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        printNxnMatrix(number);
    }

    public static void printNxnMatrix (int number){
        for (int i = 0; i < number ; i++) {
            System.out.println();
            for (int j = 0; j < number; j++) {
                System.out.print(number + " ");
            }
        }
    }
}
