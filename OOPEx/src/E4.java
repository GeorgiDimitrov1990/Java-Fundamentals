import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E4 {

    static class Article {
        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public String getAuthor() {
            return author;
        }

        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");

            Article article = new Article(input[0], input[1], input[2]);

            articles.add(article);
        }

        String input = scanner.nextLine();
        switch (input){
            case "title":
                articles.stream().sorted((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "content":
                articles.stream().sorted((a1, a2) -> a1.getContent().compareTo(a2.getContent()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "author":
                articles.stream().sorted((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
        }
    }
}
