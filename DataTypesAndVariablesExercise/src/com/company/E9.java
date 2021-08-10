package com.company;

import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int days = 0;
        int totalAmount = 0;

        while (startingYield >= 100){
            totalAmount += (startingYield - 26);
            days++;
            startingYield -= 10;
        }
        if (totalAmount > 26) {
            totalAmount -= 26;
        }
        System.out.println(days);
        System.out.println(totalAmount);
    }
}
