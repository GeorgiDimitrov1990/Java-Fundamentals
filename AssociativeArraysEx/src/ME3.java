import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ME3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> players = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Season end")) {
            String[] tokens = input.split(" -> ");
            if (tokens.length == 3) {
                String name = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                players.putIfAbsent(name, new LinkedHashMap<>());
                players.get(name).putIfAbsent(position, 0);
                if (players.get(name).get(position) < skill) {
                    players.get(name).put(position, skill);
                }
            } else if (tokens.length == 1) {
                String[] tokens2 = tokens[0].split(" vs ");
                String firstPlayer = tokens2[0];
                String secondPlayer = tokens2[1];
                boolean equalPositions = isEquals(players, firstPlayer, secondPlayer);
                if (equalPositions) {
                    int sumFirstPlayer = players.get(firstPlayer).values().stream().mapToInt(Integer::intValue).sum();
                    int sumSecondPlayer = players.get(secondPlayer).values().stream().mapToInt(Integer::intValue).sum();
                    if (sumFirstPlayer > sumSecondPlayer) {
                        players.remove(secondPlayer);
                    } else if (sumFirstPlayer < sumSecondPlayer) {
                        players.remove(firstPlayer);
                    }
                }

            }


            input = scanner.nextLine();
        }
        players.entrySet().stream()
                .sorted((p1,p2)-> {
                    int firstTotalSum = p1.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    int secondTotalSum = p2.getValue().values().stream().mapToInt(Integer::intValue).sum();
                    if (firstTotalSum != secondTotalSum){
                        return Integer.compare(secondTotalSum, firstTotalSum);
                    } else {
                        return p1.getKey().compareTo(p2.getKey());
                    }
                }).forEach(e -> {
            int totalSum = e.getValue().values().stream().mapToInt(Integer::intValue).sum();
            System.out.println(String.format("%s: %d skill", e.getKey(), totalSum));
            e.getValue().entrySet().stream()
                    .sorted((f,s)->{
                       int result = Integer.compare(s.getValue(), f.getValue());
                        if (result == 0){
                            f.getKey().compareTo(s.getKey());
                        }
                        return result;
                    }).forEach(v-> System.out.printf("- %s <::> %d%n", v.getKey(), v.getValue()));
        });
    }

    private static boolean isEquals(Map<String, Map<String, Integer>> players, String firstPlayer, String secondPlayer) {
        boolean equalPositions = false;
        if (players.containsKey(firstPlayer) && players.containsKey(secondPlayer)) {
            for (String firstPositions : players.get(firstPlayer).keySet()) {
                for (String secondPositions : players.get(secondPlayer).keySet()) {
                    if (firstPositions.equals(secondPositions)) {
                        equalPositions = true;
                        break;
                    }
                }

            }
        }
        return equalPositions;
    }
}
