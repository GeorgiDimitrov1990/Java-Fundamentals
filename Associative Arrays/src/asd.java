import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class asd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[] {1, 2, 3};
        int min = Arrays.stream(arr).min().getAsInt();
        System.out.println(min);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int max = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println(max);

        String[] words = {"a", "b", "c"};
        String[] newWords = new String[words.length];
        newWords = Arrays.stream(words).map(w -> w + "ggg").toArray(String[]::new);
    }
}
