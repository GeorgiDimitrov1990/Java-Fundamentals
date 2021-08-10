import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n ; i++) {
            if (sumOfDigits(i) % 8 == 0 && hasOddDigit(i)){
                System.out.println(i);
            }
        }
    }
    public static int sumOfDigits (int number ){
        int sumOfDigits = 0;
        while (number > 0){
            sumOfDigits += number % 10;
            number /= 10;
        }
        return sumOfDigits;
    }
    public static boolean hasOddDigit (int number){
        int digit = 0;
        while (number > 0){
            digit += number % 10;
            number /= 10;
            if (digit % 2 !=0){
                return true;
            }
        }
        return false;
    }
}
