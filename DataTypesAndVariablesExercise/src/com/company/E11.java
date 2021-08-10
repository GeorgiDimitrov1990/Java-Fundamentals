package com.company;

import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        long realSnowballValue = 0;
        int realSnowForSnowball = 0;
        int realTimeForSnowball = 0;
        int realQualityForSnowball = 0;

        for (int i = 0; i < n ; i++) {
            int snowForSnowball = Integer.parseInt(scanner.nextLine());
            int timeForSnowball = Integer.parseInt(scanner.nextLine());
            int qualityForSnowball = Integer.parseInt(scanner.nextLine());
            long snowballValue = (long)Math.pow((snowForSnowball / timeForSnowball), qualityForSnowball);
            if (snowballValue > realSnowballValue){
                realSnowballValue = snowballValue;
                realSnowForSnowball = snowForSnowball;
                realTimeForSnowball = timeForSnowball;
                realQualityForSnowball = qualityForSnowball;
            }

        }
        System.out.printf("%d : %d = %d (%d)", realSnowForSnowball, realTimeForSnowball, realSnowballValue, realQualityForSnowball);

    }
}
