import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ME5 {
    public static class Statistics {
        Double damage;
        Double health;
        Double armor;

        public Double getDamage() {
            return damage;
        }

        public void setDamage(Double damage) {
            this.damage = damage;
        }

        public Double getHealth() {
            return health;
        }

        public void setHealth(Double health) {
            this.health = health;
        }

        public Double getArmor() {
            return armor;
        }

        public void setArmor(Double armor) {
            this.armor = armor;
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Statistics>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String color = tokens[0];
            String name = tokens[1];
            String damage = tokens[2];
            String health = tokens[3];
            String armor = tokens[4];

            dragons.putIfAbsent(color, new TreeMap<>());
            dragons.get(color).putIfAbsent(name, new Statistics());
            if (damage.equals("null")) {
                double currentDamage = 45;
                dragons.get(color).get(name).setDamage(currentDamage);
            } else {
                dragons.get(color).get(name).setDamage(Double.parseDouble(damage));
            }
            if (health.equals("null")) {
                double currentHealth = 250;
                dragons.get(color).get(name).setHealth(currentHealth);
            } else {
                dragons.get(color).get(name).setHealth(Double.parseDouble(health));
            }
            if (armor.equals("null")) {
                double currentArmor = 10;
                dragons.get(color).get(name).setArmor(currentArmor);
            } else {
                dragons.get(color).get(name).setArmor(Double.parseDouble(armor));
            }

        }
        for (Map.Entry<String, Map<String, Statistics>> entry : dragons.entrySet()) {
            double damage = 0;
            double health = 0;
            double armor = 0;
            for (Map.Entry<String, Statistics> secondEntry : entry.getValue().entrySet()) {
                damage += secondEntry.getValue().getDamage();
            }
            for (Map.Entry<String, Statistics> secondEntry : entry.getValue().entrySet()) {
                health += secondEntry.getValue().getHealth();
            }
            for (Map.Entry<String, Statistics> secondEntry : entry.getValue().entrySet()) {
                armor += secondEntry.getValue().getArmor();
            }
            damage = damage/entry.getValue().size();
            health = health/entry.getValue().size();
            armor = armor/entry.getValue().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n",entry.getKey(), damage, health, armor);
            for (Map.Entry<String, Statistics> print : entry.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",print.getKey(), print.getValue().getDamage(), print.getValue().getHealth(), print.getValue().getArmor());
            }


        }


    }
}
