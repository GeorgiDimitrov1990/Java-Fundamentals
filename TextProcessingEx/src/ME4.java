import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ME4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char alphabet [] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};
        String morseCode [] = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "|"};

        Map<String, Character> morseAlphabet = new LinkedHashMap<>();
        for (int i = 0; i < alphabet.length ; i++) {
            morseAlphabet.putIfAbsent(morseCode[i], alphabet[i]);
        }

        String[] line = scanner.nextLine().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length; i++) {
            if(morseAlphabet.containsKey(line[i])){
                sb.append(morseAlphabet.get(line[i]));
            }
        }
        System.out.println(sb.toString().toUpperCase());
    }
}
