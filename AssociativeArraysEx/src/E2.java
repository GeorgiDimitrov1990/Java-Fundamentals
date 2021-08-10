import org.w3c.dom.ls.LSOutput;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mine = new LinkedHashMap<>();

        while (true) {

            String resource = scanner.nextLine();
            if (resource.equals("stop")) {
                break;
            }
            int quantity = Integer.parseInt(scanner.nextLine());
            mine.putIfAbsent(resource, 0);
            mine.put(resource, mine.get(resource) + quantity);


        }
        for (Map.Entry<String, Integer> entry : mine.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }
}
