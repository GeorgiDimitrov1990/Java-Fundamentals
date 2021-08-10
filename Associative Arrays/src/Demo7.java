import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> collect = Arrays.stream(scanner.nextLine().split(" "))
                .map(s -> Integer.parseInt(s))
                .sorted((a, b) -> Integer.compare(b, a))
                .limit(3)
                .collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.println(integer);
        }




    }
}
