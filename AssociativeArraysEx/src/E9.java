import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class E9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> forceUsers = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Lumpawaroo")) {
            String[] inputAsArray = new String[2];
            if (input.contains("|")) {
                inputAsArray = input.split(" \\| ");
                String side = inputAsArray[0];
                String name = inputAsArray[1];

                boolean exist = false;
                for (List<String> value : forceUsers.values()) {
                    if (value.contains(name)) {
                        exist = true;
                        break;
                    }
                }
                if (!exist) {
                    forceUsers.putIfAbsent(side, new ArrayList<>());

                    forceUsers.get(side).add(name);
                }

            } else {
                inputAsArray = input.split(" -> ");
                String name = inputAsArray[0];
                String side = inputAsArray[1];

                forceUsers.values().stream().filter(e -> e.remove(name)).collect(Collectors.toList());
                forceUsers.putIfAbsent(side, new ArrayList<>());
                forceUsers.get(side).add(name);

                System.out.println(String.format("%s joins the %s side!", name, side));
            }

            input = scanner.nextLine();
        }

        forceUsers.entrySet().stream().sorted((f, s) -> {
            int result = s.getValue().size() - f.getValue().size(); //sorted by size descending
            if (result == 0){
                result = f.getKey().compareTo(s.getKey()); //by name
            }
            return result;
        })
                .forEach(e -> {
                    if (!e.getValue().isEmpty()) {
                        System.out.println(String.format("Side: %s, Members: %d", e.getKey(), e.getValue().size()));
                        e.getValue()
                                .stream()
                                .sorted((f, s) -> f.compareTo(s))
                                .forEach(n -> System.out.println("! " + n));
                    }
                });
    }
}
