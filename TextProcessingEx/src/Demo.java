import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().replaceAll("\\s+", "").split(",");
        String[] winnerSymbol = {"@", "#", "$", "^"};

        for (String ticket : tickets) {
            if (ticket.length() != 20) {
                System.out.println("invalid ticket");
                continue;
            }

            String leftSide = getSymbol(winnerSymbol, ticket);
            String rightSide = getSequenceSide(leftSide.charAt(0), ticket, 10, 20);

            if (leftSide.equals("notFound") || rightSide.equals("notFound")) {
                printNoMatch(ticket);
                continue;
            }

            int length = Math.min(leftSide.length(), rightSide.length());


            String jackpot = checkJacpot(length);

            System.out.println(String.format("ticket \"%s\" - %d%s%s", ticket, length, leftSide.substring(0, 1), jackpot));

        }
    }

    private static void printNoMatch(String ticket) {
        System.out.println(String.format("ticket \"%s\" - no match", ticket));
    }

    private static String checkJacpot(int length) {
        if (length >= 10) {
            return " Jackpot!";
        }
        return "";
    }


    private static String getSymbol(String[] winnerSymbol, String ticket) {
        String returnString = "notFound";
        for (String symbol : winnerSymbol) {
            if (ticket.contains(symbol)) {
                returnString = getSequenceSide(symbol.charAt(0), ticket, 0, 10);
            }
            if (returnString.contains(symbol) && returnString.length() >= 6) {
                break;
            }
        }
        return returnString;
    }

    private static String getSequenceSide(char charAt, String ticket, int start, int end) {
        String returnString = "notFound";
        StringBuilder rightSide = new StringBuilder();

        for (int i = start; i < end; i++) {
            if (charAt == ticket.charAt(i)) {
                String add = "" + (char) (ticket.charAt(i));
                rightSide.append(add);
            } else {
                if (rightSide.length() < 6) {
                    rightSide.delete(0, rightSide.length());
                }
            }
        }
        if (rightSide.length() >= 6) {
            returnString = rightSide.toString();
        }
        return returnString;
    }
}
