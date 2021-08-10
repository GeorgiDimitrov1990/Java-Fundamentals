import org.w3c.dom.ls.LSOutput;

import java.awt.event.MouseAdapter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> results = new HashMap<>();
        Map<String, Integer> submissions = new HashMap<>();

        while (!input.equals("exam finished")) {
            String[] inputAsArray = input.split("-");

            if (inputAsArray.length == 2){


                results.remove(inputAsArray[0]);

            } else {

                String name = inputAsArray[0];
                String language = inputAsArray[1];
                int points = Integer.parseInt(inputAsArray[2]);
                results.putIfAbsent(name, points);
                for (Map.Entry<String, Integer> entry : results.entrySet()) {
                    if (entry.getKey().contains(name) && entry.getValue() < points) {
                        results.put(name, points);
                    }
                }
                submissions.putIfAbsent(language, 0);
                submissions.put(language, submissions.get(language) + 1);
            }


            input = scanner.nextLine();
        }

        System.out.println("Results:");

        results.entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    int result = s2.getValue() - s1.getValue();
                    if (result == 0) {
                        result = s1.getKey().compareTo(s2.getKey());
                    }
                    return result;
                })
                .forEach(s -> System.out.println(String.format("%s | %d", s.getKey(), s.getValue())));

        System.out.println("Submissions:");

        submissions.entrySet()
                .stream()
                .sorted((s1, s2) -> {
                    int result = s2.getValue() - s1.getValue();
                    if (result == 0) {
                        result = s1.getKey().compareTo(s2.getKey());
                    }
                    return result;
                })
                .forEach(s -> System.out.println(String.format("%s - %d", s.getKey(), s.getValue())));
    }
}
