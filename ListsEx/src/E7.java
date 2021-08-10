import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrays = scanner.nextLine().split("\\|");

        String result = "";
        for (int i =arrays.length -1 ; i >=0 ; i--) {
            String[] currentArr = arrays[i].split("\\s+");
            for (int j = 0; j <currentArr.length ; j++) {
                if (!currentArr[j].equals("")) {
                    result += currentArr[j] + " ";
                }
            }
        }
        System.out.println(result);
    }
}
