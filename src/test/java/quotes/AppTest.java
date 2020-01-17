/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AppTest {
    @Test public void testGetRandomQuote_continasKey() {
        String filePath = "src/main/resources/recentquotes.json";
        String actual = App.getRandomQuote(filePath);
        System.out.println("actual = " + actual);
        String author = "Author";
        String quote = "Quote";
        String likes = "Likes";
        String tags = "Tags";

        assertTrue(actual.contains(author));
        assertTrue(actual.contains(quote));
        assertTrue(actual.contains(likes));
        assertTrue(actual.contains(tags));
    }

    @Test public void testGetRandomQuote_Err() {
        File filePath = new File ("src/main/resources/test.json");
        assertFalse(filePath.exists());
    }

    @Test public void getRandomInt() {
        int actual = App.getRandomInt(100);
        int min = 1;
        int max = 100;
        assertTrue(min <= actual && actual <=max);
    }

    @Test public void testGetAPIQuote_continasKey() {
        String actual = App.displayQuoteBasedOnConnection("https://andruxnet-random-famous-quotes.p.rapidapi.com/?cat=famous&count=1");
        System.out.println("actual = " + actual);
        String author = "Author";
        String quote = "Quote";
        String category = "Category";
        assertTrue(actual.contains(author));
        assertTrue(actual.contains(quote));
        assertTrue(actual.contains(category));
    }

    @Test public void testWrongURL() {
        String wrongURL = " ";
        String actual = App.displayQuoteBasedOnConnection(wrongURL);
        System.out.println(actual);
        String likes = "Likes";
        String tags = "Tags";
        assertTrue(actual.contains(likes));
        assertTrue(actual.contains(tags));
    }

}
