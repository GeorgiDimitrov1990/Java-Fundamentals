package com.company;

import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        int sum = 0;
        for (int i = 0; i < input.length() ; i++) {
            char current = input.charAt(i);
            if (Character.isDigit(current)){
                System.out.println(current);
                sum += current - '0';
            }
        }
        System.out.println(sum);

    }
}
