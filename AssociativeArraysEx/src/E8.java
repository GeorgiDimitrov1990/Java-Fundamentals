import java.util.*;

public class E8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String >> companies = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] inputAsArray = input.split(" -> ");
            String companyName = inputAsArray[0];
            String employeeId = inputAsArray[1];

            companies.putIfAbsent(companyName, new ArrayList<>());
            if (!companies.get(companyName).contains(employeeId)){
                companies.get(companyName).add(employeeId);
            }

            input = scanner.nextLine();
        }

        companies.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(s -> System.out.println("-- " + s));
        });

    }
}
