import java.util.*;

public class E4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> products = new LinkedHashMap<>();
        Map<String, Double> productWithPrice = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("buy")) {
            String[] tokens = input.split(" ");
            String nameOfProduct = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);


            products.putIfAbsent(nameOfProduct, 0);
            products.put(nameOfProduct, products.get(nameOfProduct) + quantity);
            productWithPrice.put(nameOfProduct, products.get(nameOfProduct) * price );


            input = scanner.nextLine();

        }

        for (Map.Entry<String, Double> entry : productWithPrice.entrySet()) {
            System.out.println(String.format("%s -> %.2f", entry.getKey(), entry.getValue()));
        }


    }
}
