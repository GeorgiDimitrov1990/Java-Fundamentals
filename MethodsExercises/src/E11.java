import java.util.Arrays;
import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] inputArray = input.split(" ");
            String command = inputArray[0];
            switch (command){
                case "exchange":
                    int index = Integer.parseInt(inputArray[1]);
                    if (index >= 0 && index < numbers.length){
                        exchangeArray(numbers, index);
                    }else {
                        System.out.println("invalid index");
                    }
                    break;
                case "max":
                    if (inputArray[1].equals("odd")){
                        if (findMaxOddElementIndex(numbers) < 0){
                            System.out.println("No matches");
                        } else {
                            System.out.println(findMaxOddElementIndex(numbers));
                        }
                    } else {
                        if (findMaxEvenElementIndex(numbers) < 0){
                            System.out.println("No matches");
                        }else {
                            System.out.println(findMaxEvenElementIndex(numbers));
                        }
                    }
                    break;
                case "min":
                    if (inputArray[1].equals("odd")){
                        if (finMinOddElementIndex(numbers) < 0){
                            System.out.println("No matches");
                        } else {
                            System.out.println(finMinOddElementIndex(numbers));
                        }
                    } else {
                        if (finMinEvenElementIndex(numbers) < 0){
                            System.out.println("No matches");
                        } else {
                            System.out.println(finMinEvenElementIndex(numbers));
                        }
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(inputArray[1]);
                    if (countFirst > numbers.length){
                        System.out.println("Invalid count");
                    }else if(inputArray[2].equals("odd")){
                        printFirstOddNumbersCount(numbers, countFirst);
                    } else {
                        printFirstEvenNumbersCount(numbers, countFirst);
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(inputArray[1]);
                    if (countLast > numbers.length){
                        System.out.println("Invalid count");
                    }else if(inputArray[2].equals("odd")){
                        printLastOddNumberCount(numbers, countLast);
                    } else {
                        printLastEvenNumbersCount(numbers, countLast);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(Arrays.toString(numbers));
    }

    private static void printFirstEvenNumbersCount(int[] arr, int count){
        int[] numbers = new int[arr.length];
        int counter = count;
        int counterEvenNumbers = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] % 2 == 0){
                counterEvenNumbers++;
            }
        }
        if (counter > counterEvenNumbers){
            count = counterEvenNumbers;
            counter = counterEvenNumbers;
        }
        for (int i =0; i < arr.length; i++) {
            if (arr[i] % 2 == 0){
                numbers[i] = arr[i];
                counter--;
            } else {
                numbers[i] = 0;
            }
            if (counter < 0){
                numbers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(makeNewShortArray(numbers, count)));

    }

    private static void printFirstOddNumbersCount(int[] arr, int count){

        int counter = count;
        int counterOddNumbers = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] % 2 != 0){
                counterOddNumbers++;
            }
        }
        if (counter > counterOddNumbers){
            count = counterOddNumbers;
            counter = counterOddNumbers;
        }

        int[] numbers = new int[arr.length];
        for (int i =0; i < arr.length; i++) {
            if (arr[i] % 2 != 0){
                numbers[i] = arr[i];
                counter--;
            } else {
                numbers[i] = 0;
            }
            if (counter < 0){
                numbers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(makeNewShortArray(numbers, count)));
    }

    private static void printLastEvenNumbersCount(int [] arr, int count){
        int[] numbers = new int[arr.length];
        int counter = count;
        int counterEvenNumbers = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] % 2 == 0){
                counterEvenNumbers++;
            }
        }
        if (counter > counterEvenNumbers){
            count = counterEvenNumbers;
            counter = counterEvenNumbers;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 == 0){
                numbers[i] = arr[i];
                counter--;
            } else {
                numbers[i] = 0;
            }
            if (counter < 0){
                numbers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(makeNewShortArray(numbers, count)));
    }

    private static void printLastOddNumberCount(int[] arr, int count){
        int[] numbers = new int[arr.length];
        int counter = count;
        int counterOddNumbers = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] % 2 != 0){
                counterOddNumbers++;
            }
        }
        if (counter > counterOddNumbers){
            count = counterOddNumbers;
            counter = counterOddNumbers;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] % 2 != 0){
                numbers[i] = arr[i];
                counter--;
            } else {
                numbers[i] = 0;
            }
            if (counter < 0){
                numbers[i] = 0;
            }
        }
        System.out.println(Arrays.toString(makeNewShortArray(numbers, count)));
    }

    private static int[] makeNewShortArray (int [] arr, int count){
        int[] newArr = new int[count];
        int counter = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] != 0){
                newArr[i-counter]=arr[i];
            } else {
                counter++;

            }
        }
        return newArr;
    }

    private static int finMinEvenElementIndex(int[] arr){
        int minElement = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] % 2 == 0 && arr[i] <= minElement){
                minElement = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static int finMinOddElementIndex(int[] arr){
        int minElement = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] % 2 != 0 && arr[i] <= minElement){
                minElement = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static int findMaxEvenElementIndex(int[] arr){
        int maxElement = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] % 2 == 0 && arr[i] >= maxElement){
               maxElement = arr[i];
               index = i;
            }
        }

        return index;
    }

    private static int findMaxOddElementIndex(int[] arr){
        int maxElement = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] % 2 != 0 && arr[i] >= maxElement){
                maxElement = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static void exchangeArray (int[] arr, int index){
        int[] first = new int[index + 1];
        int[] second = new int [arr.length - (index + 1)];
        for (int i = 0; i <= index ; i++) {
            first[i]=arr[i];
        }
        for (int i = index +1; i <arr.length ; i++) {
            second[i - (index + 1)]= arr[i];
        }
        for (int i = 0; i < second.length ; i++) {
            arr[i]=second[i];
        }
        for (int i = 0; i < first.length ; i++) {
            arr[i + second.length] = first [i];
        }
    }
}
