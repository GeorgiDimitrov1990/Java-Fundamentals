import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class E11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        StringBuilder sb = new StringBuilder();

        int counter = 0;
        while (!input.equals("find")){
            sb.delete(0, sb.length());
            char[] chars = input.toCharArray();
            for (char aChar : chars) {

                if (counter > numbers.size() - 1) {
                    counter = 0;
                }
                int decrypt = aChar - numbers.get(counter);
                char decryptChar = (char) decrypt;
                sb.append(decryptChar);
                counter++;
            }

            String typeOfTreasure = sb.substring(sb.indexOf("&") + 1, sb.indexOf("&", sb.indexOf("&") + 1));
            String coordinates = sb.substring(sb.indexOf("<")+ 1, sb.indexOf(">"));

            System.out.printf("Found %s at %s%n", typeOfTreasure, coordinates);

            counter = 0;



            input = scanner.nextLine();
        }
    }
}
