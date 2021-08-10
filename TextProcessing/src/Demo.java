import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Character> lettersList = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equals("end")){

           lettersList.add(line.charAt(0));

            line = scanner.nextLine();
        }

        char[] lettersArray = new char[lettersList.size()];
        for (int i = 0; i < lettersArray.length ; i++) {
            lettersArray[i] = lettersList.get(i);
        }

        String output = new String(lettersArray);
        System.out.println(output.toUpperCase());
    }
}
