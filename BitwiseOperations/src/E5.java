import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] array = Arrays.stream(scanner.nextLine().split(" ")
        ).mapToInt(Integer::parseInt).toArray();
        int result = 0;
        for (int i : array) {
            result = result ^ i;
        }
        System.out.println(result);

        
    }
}
