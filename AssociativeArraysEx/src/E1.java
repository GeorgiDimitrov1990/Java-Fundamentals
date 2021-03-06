import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (char symbol : input.toCharArray()){
            if (symbol != ' '){
                if (chars.containsKey(symbol)){
                    int count = chars.get(symbol);
                    chars.put(symbol,count + 1);
                }else {
                    chars.put(symbol, 1);
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            System.out.println(entry.getKey() +  " -> " + entry.getValue());
        }

    }
}
