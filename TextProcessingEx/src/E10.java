import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String random = scanner.nextLine();
        char firstChar = first.charAt(0);
        char secondChar = second.charAt(0);
        int sum = 0;
        for (int i = 0; i < random.length() ; i++) {
            char currentChar = random.charAt(i);
            int min = Math.min(firstChar, secondChar);
            int max = Math.max(firstChar, secondChar);
            if (currentChar > min && currentChar < max){
                sum += currentChar;
            }
        }
        System.out.println(sum);
    }
}
