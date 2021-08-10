import javax.print.attribute.HashDocAttributeSet;
import java.util.Scanner;

public class Е1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());
        int[] trains = new int[wagons];
        int people = 0;

        for (int i = 0; i <trains.length ; i++) {
            trains[i] = Integer.parseInt(scanner.nextLine());
            people += trains[i];
        }
        for (int i = 0; i <trains.length ; i++) {
            System.out.print(trains[i] + " ");
        }
        System.out.println("\n" + people);
    }
}
