import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = "\\b(?<day>\\d\\d?)-(?<month>[A-z][a-z]{2})-(?<yeaar>\\d{4})\\b";
        String text = "I am born on 30-Dec-1994.\n" +
                "My father is born on the 9-Jul-1955.\n" +
                "01-July-2000 is not a valid date.\n";


       String replaced = text.replaceAll(expression, "[CENSORED]");
        System.out.println(replaced);
    }
}
