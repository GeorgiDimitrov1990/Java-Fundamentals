import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        String binString = Integer.toBinaryString(n);
        int numToBinary = Integer.parseInt(binString);

        int counter = 0;

        while (numToBinary > 0) {
            int d = numToBinary % 10;
            numToBinary /= 10;
            if (d == b) {
                counter++;
            }
        }
        System.out.println(counter);

    }

}


