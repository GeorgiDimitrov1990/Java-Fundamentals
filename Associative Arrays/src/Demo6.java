import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> filtered = Arrays.stream(scanner.nextLine().split(" "))
                .filter(w -> w.length() % 2 ==0)
                .collect(Collectors.toList());

        System.out.println(String.join(", ", filtered));
    }
}
