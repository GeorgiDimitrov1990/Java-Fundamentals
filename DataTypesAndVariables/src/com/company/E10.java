package com.company;

import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <=n ; i++) {
            int sumOfDigits = 0;

            int number = i;
            while (number > 0) {
                sumOfDigits += number % 10;

                number /= 10;
            }

            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.println(i + " -> True");

            } else {
                System.out.println(i + " -> False");
            }
        }
    }
}
