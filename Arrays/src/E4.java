import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] splitStrings = line.split(" ");

        for (int i = 0; i < splitStrings.length / 2 ; i++) {

            String swap = splitStrings[i];
            splitStrings[i] = splitStrings[splitStrings.length -1 -i];
            splitStrings[splitStrings.length -1 -i] = swap;
        }

        for (int i = 0; i < splitStrings.length ; i++) {
            System.out.print(splitStrings[i] + " ");
        }
    }
}
