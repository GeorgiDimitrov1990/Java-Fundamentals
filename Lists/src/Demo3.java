import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = parsLineOfNumbers(scanner);

        boolean searchAgain = true;

        while(searchAgain) {
            searchAgain = false;
            for (int i = 0; i < numbers.size() - 1; i++) {
                int current = numbers.get(i);
                int next = numbers.get(i + 1);
                if (current == next) {
                    numbers.remove(i);
                    numbers.set(i, current + next);
                    searchAgain = true;
                    break;
                }
            }
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }

    private static List<Integer> parsLineOfNumbers(Scanner scanner) {
        String line = scanner.nextLine();
        String[] numbersAsStrings = line.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String s : numbersAsStrings) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
        return numbers;
    }
}
