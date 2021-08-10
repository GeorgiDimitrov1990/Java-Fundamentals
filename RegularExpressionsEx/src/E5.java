import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E5 {
    static class Demons {
        String name;
        int health;
        double damage;

        public String getName() {
            return name;
        }


        public int getHealth() {
            return health;
        }


        public double getDamage() {
            return damage;
        }


        public Demons(String name, int health, double damage) {
            this.name = name;
            this.health = health;
            this.damage = damage;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> demons = Arrays.stream(scanner.nextLine().split(",\\s*")).collect(Collectors.toList());

        String healthRegex = "[^0-9+*/.,-]";
        String damageRegex = "[+-]?\\d*\\.?\\d+";
        String finalDamageRegex = "[*/]";


        Pattern healthPattern = Pattern.compile(healthRegex);
        Pattern damagePattern = Pattern.compile(damageRegex);
        Pattern finalDamagePattern = Pattern.compile(finalDamageRegex);
        List<Demons> demonsList = new ArrayList<>();
        for (int i = 0; i < demons.size(); i++) {

            String currentDemon = demons.get(i).replaceAll("\\s+", "");
            Matcher matcher = healthPattern.matcher(currentDemon);
            int health = 0;

            while (matcher.find()) {
                health += matcher.group().charAt(0);
            }

            double damage = 0;

            matcher = damagePattern.matcher(currentDemon);

            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group());
            }

            matcher = finalDamagePattern.matcher(currentDemon);

            while (matcher.find()) {
                switch (matcher.group()) {
                    case "*":
                        damage *= 2;
                        break;
                    case "/":
                        damage /= 2;
                        break;
                }
            }
            Demons demons1 = new Demons(currentDemon, health, damage);
            demonsList.add(demons1);
        }
        demonsList.stream().sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(demons1 -> System.out.printf("%s - %d health, %.2f damage%n", demons1.getName(), demons1.getHealth(), demons1.getDamage()));

    }
}
