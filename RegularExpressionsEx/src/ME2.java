import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class ME2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String toLower = input.toLowerCase();
        /*String regex = "[^0-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(toLower);
        StringBuilder symbols = new StringBuilder();
        while (matcher.find()){
            symbols.append(matcher.group());
        }
        int count = countUniqueCharacters(symbols.toString());
        System.out.println("Unique symbols used: " + count);*/

        String regex1 = "(?<string>[\\D]*)(?<count>\\d+)";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(toLower);

        StringBuilder stringBuilder = new StringBuilder();
        while (matcher1.find()){
            int currentCount = Integer.parseInt(matcher1.group("count"));
            String currentString = matcher1.group("string").toUpperCase();
            for (int i = 0; i < currentCount ; i++) {
                stringBuilder.append(currentString);
            }
        }
        System.out.printf("Unique symbols used: %d%n", stringBuilder.chars().distinct().count());
        System.out.println(stringBuilder.toString());







    }
    public static int countUniqueCharacters(String input) {
        String buffer = "";
        for (int i = 0; i < input.length(); i++) {
            if (!buffer.contains(String.valueOf(input.charAt(i)))) {
                buffer += input.charAt(i);
            }
        }
        return buffer.length();
    }
}
