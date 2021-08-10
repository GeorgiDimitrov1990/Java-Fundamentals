import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        System.out.println(subtractNums(sumNumbers(firstNum,secondNum), thirdNum));

    }
    public static int sumNumbers (int firstNum, int secondNum){
        int sumNumbers = firstNum + secondNum;
        return sumNumbers;
    }
    public static int subtractNums (int sumNumbers, int thirdNum){
        int subtractNum = sumNumbers - thirdNum;
        return subtractNum;
    }
}
