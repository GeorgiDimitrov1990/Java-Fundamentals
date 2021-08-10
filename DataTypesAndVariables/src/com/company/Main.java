package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	 int cents = new Scanner(System.in).nextInt();
	 double convertedCents = cents * 1.31;
	 int wholeDollars = (int) (convertedCents / 100);
	 int wholeCents = (int) (convertedCents % 100);

        System.out.printf("%02d.%02d", wholeDollars, wholeCents);
    }
}
