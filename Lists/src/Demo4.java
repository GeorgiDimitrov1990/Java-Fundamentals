import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = parsLineOfNumbers(scanner);
        List<Integer> secondList = parsLineOfNumbers(scanner);
        
        List<Integer> mergedList = new ArrayList<>();

        int indexInFirst = 0;
        int indexInSecond = 0;

        while (indexInFirst < firstList.size() || indexInSecond < secondList.size()){
            if (indexInFirst < firstList.size()) {
                mergedList.add(firstList.get(indexInFirst));
            }
            if (indexInSecond < secondList.size()) {
                mergedList.add(secondList.get(indexInSecond));
            }
            indexInFirst++;
            indexInSecond++;
        }

        for (Integer integer : mergedList) {
            System.out.print(integer + " ");
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
