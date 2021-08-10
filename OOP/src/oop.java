import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class oop {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> reservationHolders = new ArrayList<>();
        List<Integer> reservationSeats = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] nameAndSeats = input.split(" ");
            String holder = nameAndSeats[0];
            int seats = Integer.parseInt(nameAndSeats[1]);
            reservationHolders.add(holder);
            reservationSeats.add(seats);


            input = scanner.nextLine();
        }

        String guestName = scanner.nextLine();
        int reservationIndex = -1;
        for (int i = 0; i < reservationHolders.size() ; i++) {
            if (guestName.equals(reservationHolders.get(i)))  {
                reservationIndex = i;
            }

            // int reservationIndex = reservationHolders.indexOf(guestName);

        }
        if (reservationIndex != -1){
            System.out.println(reservationSeats.get(reservationIndex));

        }else {
            System.out.println("Sorry, no reservation for " + guestName);
        }


    }
}
