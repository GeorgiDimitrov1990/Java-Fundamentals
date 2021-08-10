import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String arrayAsString = scanner.nextLine();
        String[] numbersAsStrings =  arrayAsString.split(" ");


        int [] arr = new int[numbersAsStrings.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
