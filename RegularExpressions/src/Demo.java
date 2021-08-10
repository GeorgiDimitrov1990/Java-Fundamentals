import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "Hello regular expressions, this is l3cture number 7 in java 2020";

        StringBuilder currentNumberStr = new StringBuilder();
        for (int i = 0; i < text.length() ; i++) {
            char currentChar = text.charAt(i);
            if (Character.isDigit(currentChar)){
                currentNumberStr.append(currentChar);
            } else if (currentNumberStr.length() != 0){
                System.out.println(currentNumberStr);
                currentNumberStr.delete(0, currentNumberStr.length());
            }
        }
        if (currentNumberStr.length() != 0){
            System.out.println(currentNumberStr);
            currentNumberStr.delete(0, currentNumberStr.length());
        }
    }
}
