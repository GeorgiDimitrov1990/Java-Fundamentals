import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        printMiddleChar(input);
    }

    public static void printMiddleChar (String input){
        if (input.length() % 2 == 0){
            System.out.print(input.charAt((input.length() / 2) -1));
            System.out.print(input.charAt(input.length() / 2));
        } else {
            System.out.println(input.charAt(input.length() / 2));
        }
    }
}
