import java.util.Date;
import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = "apple";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3 ; i++) {
            sb.append(word);
        }
        System.out.println(sb.toString());
        System.out.println(sb.charAt(5));

    }
}
