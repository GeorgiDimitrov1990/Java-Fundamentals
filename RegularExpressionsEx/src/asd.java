import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class asd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex1 = "(?<string>[\\D]*)(?<count>\\d+)";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(input);

        StringBuilder stringBuilder = new StringBuilder();
        while (matcher1.find()){
            int currentCount = Integer.parseInt(matcher1.group("count"));
            String currentString = matcher1.group("string").toUpperCase();
            for (int i = 0; i < currentCount ; i++) {
                stringBuilder.append(currentString);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
