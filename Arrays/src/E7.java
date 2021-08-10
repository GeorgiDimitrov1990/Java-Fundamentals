import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numAsString = line.split(" ");

        int[] numbers = new int[numAsString.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numAsString[i]);
        }
        int[] condensed = new int[numbers.length-1];


            while (numbers.length != 1) {
                for (int i = 0; i < condensed.length; i++) {
                    condensed[i] = numbers[i] + numbers[i + 1];
                    if (condensed.length == 1){
                        break;
                    }

                }
                numbers = condensed;
                condensed = new int [numbers.length -1];


            }
            System.out.println(numbers[0]);

    }
}
