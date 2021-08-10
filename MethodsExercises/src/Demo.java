import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 3;
        int[] arr = new int[] {0, 0, 0, 0, 7, 9, 11};
        int[] newArr = new int[count];
        int counter = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] != 0){
                newArr[i-counter]=arr[i];
            }else {
                counter++;

            }
        }

        System.out.println(Arrays.toString(newArr));

    }
}
