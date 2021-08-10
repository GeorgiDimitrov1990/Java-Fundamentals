import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ME4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Once upon a time")){

            String[] tokens = input.split(" <:> ");
            String name = tokens[0];
            String hatColor = tokens[1];
            int strength = Integer.parseInt(tokens[2]);

            dwarfs.putIfAbsent(hatColor, new LinkedHashMap<>());
            dwarfs.get(hatColor).putIfAbsent(name, 0);
            if (dwarfs.get(hatColor).get(name) < strength){
                dwarfs.get(hatColor).put(name, strength);
            }


            input = scanner.nextLine();
        }

        Map<String, Integer> newMap = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : dwarfs.entrySet()) {
            for (Map.Entry<String, Integer> secondEntry : entry.getValue().entrySet()) {
                newMap.put(entry.getKey() + " " + secondEntry.getKey() + " " + entry.getValue().size(), secondEntry.getValue());
            }

        }

        newMap.entrySet()
                .stream()
                .sorted((f,s) ->{
                    int result = Integer.compare(s.getValue(), f.getValue());
                    if (result == 0){
                        String[] first = f.getKey().split(" ");
                        String[] second = s.getKey().split(" ");
                        result = second[2].compareTo(first[2]);
                    }
                    return result;
                })
                .forEach(e->{
                    String[] array = e.getKey().split(" ");
                    System.out.printf("(%s) %s <-> %d%n", array[0], array[1], e.getValue());
                });

    }
}
