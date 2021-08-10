import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ME3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\|");
        Map<Character, Integer> secondPart = new LinkedHashMap<>();

        String firstPartRegex = "([#\\$%*&])[A-Z]+(\\1)";
        Pattern firstPartPattern = Pattern.compile(firstPartRegex);
        Matcher firstPartMatcher = firstPartPattern.matcher(input[0]);

        String capitalLetters = "";

        while (firstPartMatcher.find()){
            String current = firstPartMatcher.group();
            capitalLetters = current.substring(1, current.length()-1);

        }
        for (int i = 0; i < capitalLetters.length() ; i++) {
            char currentChar = capitalLetters.charAt(i);
            String secondPartRegex = "([0-9]{2}):([0-9]{2})";
            Pattern secondPattern = Pattern.compile(secondPartRegex);
            Matcher secondMatcher = secondPattern.matcher(input[1]);

            while (secondMatcher.find()){
                String[] currentArr = secondMatcher.group().split(":");
                int asciiCode = Integer.parseInt(currentArr[0]);
                int wordLength = Integer.parseInt(currentArr[1]);

                if (currentChar == asciiCode && !secondPart.containsKey(currentChar)){
                    secondPart.put(currentChar, wordLength+1);
                    break;
                }
            }
        }

        String[] thirdPart = input[2].split(" ");

        for (int i = 0; i < capitalLetters.length() ; i++) {
            char firstLetter = capitalLetters.charAt(i);
            int lengthForWord = secondPart.get(firstLetter);

            for (int j = 0; j < thirdPart.length; j++) {
                char currentChar = thirdPart[j].charAt(0);
                int currentLength = thirdPart[j].length();

                if (firstLetter == currentChar && lengthForWord == currentLength){
                    System.out.println(thirdPart[j]);
                }

            }
        }





    }
}
