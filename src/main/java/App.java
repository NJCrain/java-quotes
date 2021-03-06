import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */
public class App {

    public static void main(String[] args) {
        Quote swansonism = Quote.getWebQuote();
        ArrayList<Quote> quotes = Quote.quoteList();
        if (swansonism == null) {
            int random = ThreadLocalRandom.current().nextInt(quotes.size());
            System.out.println(quotes.get(random));
        } else {
            swansonism.saveQuote(quotes);
            System.out.println(swansonism);
        }
    }
}
