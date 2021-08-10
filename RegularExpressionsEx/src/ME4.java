import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        String regex = "@[A-Za-z]+[^@!:>-]*![G]!";
        Pattern pattern = Pattern.compile(regex);
        while (!input.equals("end")) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char current = (char) (input.charAt(i) - n);
                sb.append(current);
            }
            Matcher matcher = pattern.matcher(sb.toString());
            while (matcher.find()){
                Pattern pattern1 = Pattern.compile("@[A-Za-z]+");
                Matcher matcher1 = pattern1.matcher(matcher.group());
                while (matcher1.find()){
                    String name = matcher1.group().substring(1);
                    System.out.println(name);
                }
            }


            input = scanner.nextLine();
        }
    }
}
