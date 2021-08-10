import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        list.add(255);
        list.add(13);
        list.add(99);
        for (int i = 0; i < list.size() ; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        list.set(0, 13);
        list.set(1, 101);
        for (int i = 0; i < list.size() ; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
