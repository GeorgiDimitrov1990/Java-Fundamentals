import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArray = readArray(scanner);
        int[] secondArray = readArray(scanner);

        printArray(secondArray);
        printArray(firstArray);

    }




    static void printArray(int[] array){
        for (int number : array){
            System.out.println(number + " ");
        }
    }

    private static int[] readArray(Scanner scanner) {

        String line = scanner.nextLine();
        String[] numberAsString = line.split(" ");
        int[] array = new int[numberAsString.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Integer.parseInt(numberAsString[i]);
        }
        return array;
    }
}
