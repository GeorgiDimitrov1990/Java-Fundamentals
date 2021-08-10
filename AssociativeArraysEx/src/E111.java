import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class E111 {

    static class StudentsInfo {
        String contest;
        int points;

        public StudentsInfo(String contest, int points) {
            this.contest = contest;
            this.points = points;
        }

        public String getContest() {
            return contest;
        }

        public void setContest(String contest) {
            this.contest = contest;
        }

        public int getPoints() {
            return points;
        }

        public void setPoints(int points) {
            this.points = points;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordsForContest = new HashMap<>();
        Map<String, Map<String, Integer>> studentsResults = new TreeMap<>();
        Map<String, Integer> bestStudent = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end of contests")) {
            String[] tokens = input.split(":");
            String contest = tokens[0];
            String password = tokens[1];
            passwordsForContest.put(contest,password);

            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();

        while (!input2.equals("end of submissions")) {
            String[] tokens = input2.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);



            if (passwordsForContest.containsKey(contest)) {
                if (passwordsForContest.get(contest).equals(password)) {

                    LinkedHashMap<String, Integer> course = new LinkedHashMap<>();
                    course.put(contest, points);

                    if (!studentsResults.containsKey(username)) {
                        studentsResults.put(username, course);
                    } else {
                        if (!studentsResults.get(username).containsKey(contest)) {
                            studentsResults.get(username).put(contest, points);
                        } else {
                            studentsResults.get(username).put(contest, Math.max(points, studentsResults.get(username).get(contest)));
                        }
                    }
                }
            }


            input2 = scanner.nextLine();
        }
        int totalSum = 0;
        for (Map.Entry<String, Map<String, Integer>> user : studentsResults.entrySet()) {
            int sum = user.getValue().values().stream().mapToInt(i -> i).sum();
            if (sum > totalSum) {
                totalSum = sum;
            }
        }

        for (Map.Entry<String, Map<String, Integer>> user : studentsResults.entrySet()) {
            if (user.getValue().values().stream().mapToInt(i -> i).sum() == totalSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", user.getKey(), totalSum);
            }
        }


        System.out.println("Ranking:");

        studentsResults.forEach((k,v)-> {
            System.out.printf("%s%n",k);
            v.entrySet().stream()
                    .sorted((f,s) -> s.getValue() - f.getValue())
                    .forEach(i-> System.out.println(String.format("#  %s -> %d", i.getKey(), i.getValue())));
        });
    }
}
