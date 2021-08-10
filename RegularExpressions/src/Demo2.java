import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = "[A-Z][A-Za-z]+";
        String text = "Hello regular expressions, this is l3cture number 7 at SoftUni in java 2020";


        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
