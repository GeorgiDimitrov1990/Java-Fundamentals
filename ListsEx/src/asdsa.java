import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class asdsa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line =scanner.nextLine();
        List<String> strings = new ArrayList<>(Arrays.asList(line.split("\\s+")));
        String input = scanner.nextLine();
        while (!input.equals("3:1")){
            String[] inputAsArray = input.split("\\s+");
            String command = inputAsArray[0];
            int first = Integer.parseInt(inputAsArray[1]);
            int second = Integer.parseInt(inputAsArray[2]);
            switch (command){
                case "merge":
                    String merge = "";
                    if (first < 0){
                        first = 0;
                    }
                    if (first < strings.size()-1) {
                        if (second > strings.size()-1){
                            second = strings.size() - 1;
                        }
                        for (int i = first; i <= second; i++) {
                            merge += strings.get(i);
                        }
                        for (int i = first; i <= second; i++) {
                            strings.remove(first);
                        }
                        strings.add(first, merge);
                    }
                    break;
                //qrstuvwxyzo qr
                //qr st uv wx yz
                case "divide":
                    int indexDivide = first;
                    int divideTimes = second;

                    List<String> dividedString = new ArrayList<>();
                    String currentElement = strings.get(indexDivide);
                    int substringsLength = currentElement.length() / divideTimes;
                    int count = 0;
                    String separatedElement = "";
                    int counterAdded = 0;

                    for (int i = 0; i < currentElement.length(); i++) {

                        char symbol = currentElement.charAt(i);
                        separatedElement += symbol;
                        count++;

                        if (count == substringsLength && counterAdded + 1 < divideTimes) {
                            dividedString.add(separatedElement);
                            count = 0;
                            counterAdded++;
                            separatedElement = "";
                        }
                    }
                    ///1234
                    dividedString.add(separatedElement);
                    strings.remove(indexDivide);

                    for (int i = dividedString.size() - 1; i >= 0; i--) {
                        strings.add(indexDivide, dividedString.get(i));
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i) + " ");
        }
    }
}
