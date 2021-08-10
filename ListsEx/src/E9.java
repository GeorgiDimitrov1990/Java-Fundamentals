import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int counter = 0;
        while (!sequence.isEmpty()){
            int givenIndex = Integer.parseInt(scanner.nextLine());
            if (givenIndex < 0 || givenIndex > sequence.size() - 1){
                if (givenIndex<0){
                    counter += sequence.get(0);
                } else if (givenIndex > sequence.size() -1){
                    counter += sequence.get(sequence.size()-1);
                }
                changeTheValueIfIndexIsOutOfBounds(sequence, givenIndex);
            } else {
                counter += sequence.get(givenIndex);
                increaseAndDecreaseTheValue(sequence, givenIndex);
            }

        }
        System.out.println(counter);

    }


    public static List<Integer> increaseAndDecreaseTheValue(List<Integer> sequence, int givenIndex){
    int currentIndex = sequence.get(givenIndex);
    sequence.remove(givenIndex);
    if (sequence.isEmpty()){
        return sequence;
    }
        for (int i = 0; i <sequence.size() ; i++) {
            if (sequence.get(i) <= currentIndex){
                sequence.set(i, sequence.get(i) + currentIndex);
            }else {
                sequence.set(i, sequence.get(i) - currentIndex);
            }
        }
        return sequence;
    }

    public static List<Integer> changeTheValueIfIndexIsOutOfBounds(List<Integer> sequence, int givenIndex){
        if (givenIndex < 0){
            int firstElement = sequence.get(0);
            sequence.remove(0);
            if (sequence.isEmpty()){
                return sequence;
            }
            for (int i = 0; i < sequence.size() ; i++) {
                if (sequence.get(i) <= firstElement){
                    sequence.set(i, sequence.get(i) + firstElement);
                }else {
                    sequence.set(i, sequence.get(i) - firstElement);
                }
            }
            sequence.add(0, sequence.get(sequence.size() - 1));

        } else if (givenIndex > sequence.size() - 1){
            int lastElement = sequence.get(sequence.size() - 1);
            sequence.remove(sequence.size() - 1);
            if (sequence.isEmpty()){
                return sequence;
            }
            for (int i = 0; i < sequence.size() ; i++) {
                if (sequence.get(i) <= lastElement){
                    sequence.set(i, sequence.get(i) + lastElement);
                }else {
                    sequence.set(i, sequence.get(i) - lastElement);
                }
            }
            sequence.add(sequence.get(0));
        }
        return sequence;
    }

}
