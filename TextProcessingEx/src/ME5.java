import java.util.Scanner;

public class ME5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String article = scanner.nextLine();
        String content = scanner.nextLine();
        System.out.printf("<h1>%n %s%n</h1>%n",article);
        System.out.printf("<article>%n %s%n</article>%n",content);
        String input = scanner.nextLine();

        while (!input.equals("end of comments")){

            System.out.printf("<div>%n %s%n</div>%n", input);

            input = scanner.nextLine();
        }
    }
}
