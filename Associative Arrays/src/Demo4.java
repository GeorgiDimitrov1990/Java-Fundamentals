import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        words.add("dog");
        words.add("cat");
        words.add("bat");
        words.add("craftBeer");

        List<String> filtered = words.stream()
                .filter(w -> w.length() <= 5)
                .map(w -> w.toUpperCase())
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", filtered));
    }
}
