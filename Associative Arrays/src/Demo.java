import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String , Integer> infectedByCity = new HashMap<>();

        String command = scanner.next();
        while (!command.equals("end")){
            if (command.equals("report")){
                String cityName = scanner.next();

                System.out.println(infectedByCity.get(cityName));
            } else {
                int infected = scanner.nextInt();

                Integer currentInfected = infectedByCity.get(command);
                if (currentInfected == null){
                    currentInfected = 0;
                }
                infectedByCity.put(command, currentInfected + infected);

            }

            command = scanner.next();
        }
        for (Map.Entry<String, Integer> entry : infectedByCity.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
