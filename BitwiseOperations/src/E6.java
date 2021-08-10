import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int mask = 7 << b;
        int invertMask = n ^ mask;
        System.out.println(invertMask);

    }
}
