import java.util.Arrays;
import java.util.Scanner;

public class ME6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().replaceAll(" ", "").split(",");
        String[] winningSymbols = {"@", "#", "$", "^"};
        for (String ticket : tickets) {
            if (ticket.length() != 20){
                System.out.println("invalid ticket");
                continue;
            }
            String leftSide = checkLeftSide(winningSymbols, ticket);
        }


    }

    private static String checkLeftSide(String[] winningSymbols, String ticket) {
        String returnString = "not found";
        for (String symbol : winningSymbols) {

        }
        return returnString;

    }

}
