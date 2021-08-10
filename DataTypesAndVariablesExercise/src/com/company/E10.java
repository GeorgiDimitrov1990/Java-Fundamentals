package com.company;

import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());
        int distanceBetweenTargets = Integer.parseInt(scanner.nextLine());
        byte exhaustionFactor = Byte.parseByte(scanner.nextLine());

        int countPokes = 0;
        double halfPokePower = (double)pokePower / 2;
        while (pokePower >= distanceBetweenTargets){
            pokePower -= distanceBetweenTargets;

            if (pokePower == halfPokePower && exhaustionFactor !=0){
                pokePower = pokePower / exhaustionFactor;
            }
            countPokes++;
        }

        System.out.println(pokePower);
        System.out.println(countPokes);


    }
}
