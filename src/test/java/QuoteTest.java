import org.junit.Test;

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
}