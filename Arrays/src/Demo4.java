import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = new String[] {"Georgi", "e", "gotin"};

        String s = String.join("----*-", words);
        System.out.println(s);
    }
}
