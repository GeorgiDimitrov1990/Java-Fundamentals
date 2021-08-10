import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] numAsString = line.split(" ");
        int[] numbers = new int[numAsString.length];
        for (int i = 0; i < numAsString.length ; i++) {
            numbers[i] = Integer.parseInt(numAsString[i]);
        }
        int sum = 0;
        for (int i = 0; i <numbers.length ; i++) {
            if (numbers[i] % 2 == 0){
                sum += numbers[i];
            }
        }

        System.out.println(sum);
    }
}
