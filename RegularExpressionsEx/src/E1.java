import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> furniture = new ArrayList<>();
        double cost = 0;
        String input = scanner.nextLine();
        while (!input.equals("Purchase")) {

            String regex = ">>(?<name>[A-Za-z]+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furniture.add(name);
                cost += (price * quantity);

            }


            input = scanner.nextLine();
        }

        System.out.println("Brought furniture:");
        furniture.forEach(f-> System.out.println(f));
        System.out.println("Total money spend: " + cost);
    }
}
