import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!input.equals("END")){
            int num = Integer.parseInt(input);
            System.out.println(isNumberPalindrome(num));
            input = scanner.nextLine();
        }

    }

    public static boolean isNumberPalindrome(int num){
        int reverseNum = 0;
        int comparisonNum = num;
        while (comparisonNum > 0){
            int digit = comparisonNum % 10;
            reverseNum = reverseNum * 10 + digit;
            comparisonNum /= 10;

        }
        if (num != reverseNum){
            return false;
        }
        return true;
    }
}
