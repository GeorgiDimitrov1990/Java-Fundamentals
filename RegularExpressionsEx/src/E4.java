import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();

        String countRegex = "[STARstar]";
        Pattern countPattern = Pattern.compile(countRegex);

        String validRegex = "(?<name>[A-Za-z]+)[^@\\-!:]*:(?<population>\\d+)[^@\\-!:]*!(?<type>[A|D])![^@\\-!:]*->(?<soldiers>\\d+)";
        Pattern validPattern = Pattern.compile(validRegex);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String input = scanner.nextLine();
            Matcher matcher = countPattern.matcher(input);

            int counter = 0;
            while (matcher.find()){
                counter++;
            }
            
            StringBuilder decryptedMsg = new StringBuilder();

            for (int j = 0; j < input.length(); j++) {
                decryptedMsg.append((char) (input.charAt(j) - counter));

            }

            matcher = validPattern.matcher(decryptedMsg.toString());

            if (matcher.find()){
                String planer = matcher.group("name");
                String type = matcher.group("type");
                if (type.equals("A")){
                    attacked.add(planer);
                } else {
                    destroyed.add(planer);
                }
            }

        }

        System.out.println("Attacked planets: " + attacked.size());
        attacked.stream().sorted((a,b) -> a.compareTo(b)).forEach(a -> System.out.println("-> " + a));
        System.out.println("Destroyed planets: " + destroyed.size());
        destroyed.stream().sorted((a,b) -> a.compareTo(b)).forEach(d-> System.out.println("-> " + d));
    }

}
