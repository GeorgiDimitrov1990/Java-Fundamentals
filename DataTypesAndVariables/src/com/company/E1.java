package com.company;

import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        long sum = 0L;
        for (int i = 0; i < input ; i++) {
            long number = Long.parseLong(scanner.nextLine());
            sum += number;
        }
        System.out.println(sum);
    }
}
