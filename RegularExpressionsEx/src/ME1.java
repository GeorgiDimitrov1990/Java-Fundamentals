import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tickets = scanner.nextLine().split(",\\s+");


        for (int i = 0; i < tickets.length ; i++) {
            String ticket = tickets[i].replaceAll("\\s+", "");
            if (ticket.length() == 20){
                String rightSide = getRightSide(ticket);
                String leftSide = getLeftSide(ticket);
                String regex = "@{6,10}|#{6,10}|\\${6,10}|\\^{6,10}";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(rightSide);
                String winRightSide = "";
                while (matcher.find()) {
                    winRightSide = matcher.group();
                }
                if (winRightSide.isEmpty()){
                    System.out.println(String.format("ticket \"%s\" - no match", ticket));
                    continue;
                }
                matcher = pattern.matcher(leftSide);
                String winLeftSide = "";
                while (matcher.find()){
                    winLeftSide = matcher.group();
                }
                if (winLeftSide.isEmpty()){
                    System.out.println(String.format("ticket \"%s\" - no match", ticket));
                    continue;
                }
                if (winRightSide.charAt(0) == winLeftSide.charAt(0)){
                    if (winLeftSide.length() == 10 && winRightSide.length() == 10){
                        System.out.printf("ticket \"%s\" - %d%c Jackpot!%n",ticket, winLeftSide.length(), winLeftSide.charAt(0));
                    } else {
                        System.out.printf("ticket \"%s\" - %d%c%n",ticket, Math.min(winLeftSide.length(), winRightSide.length()), winLeftSide.charAt(0));
                    }
                }
            } else {
                System.out.println("invalid ticket");
            }
        }
    }

    private static String getRightSide(String ticket) {
        StringBuilder sb = new StringBuilder();
        for (int i = 10; i < ticket.length(); i++) {
            sb.append(ticket.charAt(i));
        }
        return sb.toString();
    }

    private static String getLeftSide(String ticket) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10 ; i++) {
            sb.append(ticket.charAt(i));
        }
        return sb.toString();
    }

}
