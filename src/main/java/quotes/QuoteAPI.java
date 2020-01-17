package quotes;

public class QuoteAPI {
    String quote;
    String author;
    String category;

    public QuoteAPI(String quote, String author, String category) {
        this.quote = quote;
        this.author = author;
        this.category = category;
    }

    public String toString() {

        String randomQuote = "Author: "+ this.author +  ", Quote: \"" + this.quote + "\", Category: " + this.category;
        return randomQuote;
    }

}
