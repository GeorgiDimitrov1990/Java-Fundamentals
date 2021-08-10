import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class oop1 {


    static class Reservation{
        String holderName;
        int seats;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Reservation> reservations = new ArrayList<>();


        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] nameAndSeats = input.split(" ");
            String holder = nameAndSeats[0];
            int seats = Integer.parseInt(nameAndSeats[1]);
            Reservation r = new Reservation();
            r.holderName = holder;
            r.seats = seats;
            reservations.add(r);


            input = scanner.nextLine();
        }

        String guestName = scanner.nextLine();
        int reservationIndex = -1;
        for (int i = 0; i < reservations.size() ; i++) {
            Reservation reservation = reservations.get(i);
            if (guestName.equals(reservation.holderName))  {
                reservationIndex = i;
            }

            // int reservationIndex = reservationHolders.indexOf(guestName);

        }
        if (reservationIndex != -1){
            Reservation reservation = reservations.get(reservationIndex);
            System.out.println(reservation.seats);

        }else {
            System.out.println("Sorry, no reservation for " + guestName);
        }

    }
}
