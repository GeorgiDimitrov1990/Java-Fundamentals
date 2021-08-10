import java.util.*;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         List<Integer> numbers = parsLineOfNumbers(scanner);

         List<Integer> nonNegativeNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (number >= 0){
                nonNegativeNumbers.add(number);
            }
        }

        if (nonNegativeNumbers.isEmpty()){
            System.out.println("empty");
        }else {

            Collections.reverse(nonNegativeNumbers);
            for (Integer nonNegativeNumber : nonNegativeNumbers) {
                System.out.print(nonNegativeNumber + " ");
            }
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
