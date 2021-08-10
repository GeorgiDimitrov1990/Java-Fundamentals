import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "Hello and goodbye";
        int currentIndex = text.indexOf("o");

        while (currentIndex != -1){

            System.out.println(currentIndex);

            currentIndex = text.indexOf("o", currentIndex +1);
        }
    }
}
