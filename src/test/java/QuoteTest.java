import com.sun.org.apache.xpath.internal.operations.Quo;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuoteTest {

    @Test
    public void testConstructor(){
        Quote quote = new Quote("Test", "Test Text");

        assertEquals("quote.author should be Test", "Test", quote.author);
        assertEquals("quote.text should be Test Text", "Test Text", quote.text);
    }

    @Test
    public void testToString() {
        Quote quote = new Quote("TestAuthor", "\"Test Text\"");
        assertEquals("should return \"quote\" - author", "\"Test Text\" - TestAuthor", quote.toString());

        Quote quote2 = new Quote("TestAuthor", "\"TestText\"");
        assertEquals("should return \"quote\" - author", "\"TestText\" - TestAuthor", quote2.toString());

        Quote quote3 = new Quote("TestAuthor", "\"Test/Text\"");
        assertEquals("should return \"quote\" - author", "\"Test/Text\" - TestAuthor", quote3.toString());
    }

    @Test
    public void testQuoteList() {
        ArrayList<Quote> quotes = Quote.quoteList();

        assertTrue("Should give a list with size of at least 1 (assuming you don't remove every quote from the file", quotes.size() > 0);
    }

    @Test
    public void testGetWebQuote() {
        Quote test = Quote.getWebQuote();

        assertNotNull("Given you have an internet connection, the quote should have text", test.text);
        assertEquals("The author should be Ron Swanson", "Ron Swanson", test.author);
    }

    @Test
    public void testSaveQuote() {
        ArrayList<Quote> quotes = Quote.quoteList();
        int originalSize = quotes.size();
        Quote test = Quote.getWebQuote();
        test.saveQuote(quotes);

        assertEquals("Should add a new quote to the array list, increasing its size", originalSize + 1, quotes.size());
        assertEquals("The quote at the last index should be the one we just saved", test, quotes.get(originalSize));
    }
}