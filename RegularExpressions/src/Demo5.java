import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo5 {
    public static void main(String[] args) {
        String text = "Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Test Testov, Ivan\tIvanov\n";
        String expression = "\\b[A-Z][a-z]+ [A-Z][a-z]+\\b";

        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
