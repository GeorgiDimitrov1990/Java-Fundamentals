import org.w3c.dom.ls.LSOutput;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> participants = new LinkedHashMap<>();
        Map<String, Integer> namesAndScores = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("no more time")) {
            String[] tokens = input.split(" -> ");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            Map<String, Integer> users = new LinkedHashMap<>();
            users.put(username, points);
            if (!participants.containsKey(contest)) {
                participants.put(contest, users);
                namesAndScores.putIfAbsent(username, 0);
                namesAndScores.put(username, namesAndScores.get(username) + points);
            } else {
                if (!participants.get(contest).containsKey(username)) {
                    participants.get(contest).put(username, points);
                    namesAndScores.putIfAbsent(username, 0);
                    namesAndScores.put(username, namesAndScores.get(username) + points);
                } else {
                    participants.get(contest).put(username, Math.max(points, participants.get(contest).get(username)));
                    int sum = points - namesAndScores.get(username);
                    if (sum > 0) {
                        namesAndScores.put(username, namesAndScores.get(username) + sum);
                    }
                }
            }

            input = scanner.nextLine();
        }


        participants.forEach((key, value) -> {
            final int[] count1 = {0};
            System.out.println(String.format("%s: %d participants", key, value.size()));
            value.entrySet()
                    .stream()
                    .sorted((f, s) -> {
                        int result = s.getValue() - f.getValue();
                        if (result == 0) {
                            result = f.getKey().compareTo(s.getKey());
                        }
                        return result;
                    })
                    .forEach(e -> {
                        count1[0]++;
                        System.out.println(String.format("%d. %s <::> %d",count1[0], e.getKey(), e.getValue()));
                    });
        });

        System.out.println("Individual standings:");

        final int[] count = {0};
        namesAndScores.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue() - f.getValue();
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(e-> {
                    count[0] ++;
                    System.out.println(String.format("%d. %s -> %d",count[0],e.getKey(),e.getValue()));
        });



    }
}
