import java.util.Arrays;
import java.util.Scanner;

public class Е9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int realIndex = 0;
        int realCounter2 = 0;
        int realCountSamples = 0;
        int countSamples = 0;
        int realCounterOnes = 0;
        int[] bestSequence = new int[length];

        while (!input.equals("Clone them!")) {
            int[] sequence = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt).toArray();
            countSamples++;
            int counterOnes = 0;
            for (int i = 0; i < sequence.length; i++) {
                if (sequence[i] == 1) {
                    counterOnes++;
                }
            }
            if (sequence.length < length) {
                break;
            }
            int realCounter = 0;
            int counter = 1;
            int index = length;
            for (int i = 1; i < sequence.length; i++) {
                if (sequence[i] == sequence[i - 1] && sequence[i] != 0) {
                    counter++;

                    if (counter > realCounter) {
                        realCounter = counter;
                    }
                    if (index > i - 1) {
                        index = i - 1;
                    }
                } else {
                    counter = 1;
                }
            }
            if (realCounter > realCounter2) {
                realCounter2 = realCounter;
                realIndex = index;
                realCountSamples = countSamples;
                realCounterOnes = counterOnes;
                for (int i = 0; i < sequence.length; i++) {
                    bestSequence[i] = sequence[i];
                }
            }

            if (realCounter == realCounter2) {
                if (index < realIndex) {
                    realIndex = index;
                    realCountSamples = countSamples;
                    realCounterOnes = counterOnes;
                    for (int i = 0; i < sequence.length; i++) {
                        bestSequence[i] = sequence[i];
                    }
                }
                if (index == realIndex && counterOnes > realCounterOnes) {
                    realCounterOnes = counterOnes;
                    for (int i = 0; i < sequence.length; i++) {
                        bestSequence[i] = sequence[i];
                        realCountSamples = countSamples;
                    }
                }

            }


            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", realCountSamples, realCounterOnes);
        for (int i = 0; i < bestSequence.length; i++) {
            System.out.print(bestSequence[i] + " ");
        }

    }
}
