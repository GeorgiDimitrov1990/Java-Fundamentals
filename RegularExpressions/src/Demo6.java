import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String expression = "(?<day>\\d{1,2})([./-])(?<month>[A-Z][a-z]{2})(\\2)(?<year>\\d{4})";

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){

            System.out.println("Day " + matcher.group("day") + ", Month: "+ matcher.group("month") + ", Year: " + matcher.group("year"));

        }
    }
}
