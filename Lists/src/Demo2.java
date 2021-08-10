import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = parsLineOfNumbers(scanner);


        int i = 0;
        while (i < numbers.size()){
            if (numbers.get(i) < 0){
                numbers.remove(i);
            }else {
                i++;
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
