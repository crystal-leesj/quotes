/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class App {

    public static void main(String[] args) {
        displayQuoteBasedOnConnection("https://andruxnet-random-famous-quotes.p.rapidapi.com/?cat=famous&count=1");
    }

    public static String displayQuoteBasedOnConnection(String urlString){
        try {
            return connectToURL(urlString);
        } catch (IOException e) {
            System.out.println(getRandomQuote("src/main/resources/recentquotes.json"));
            return getRandomQuote("src/main/resources/recentquotes.json");
        }
    }
    public static int getRandomInt(int arrLength) {
        Random rand = new Random();
        int randInt = rand.nextInt(arrLength - 1);
        return randInt;
    }
    public static String getRandomQuote(String filePath) {
        try {

            FileReader file = new FileReader(filePath);

            Gson gson = new Gson();

            Quote[] quoteArray = gson.fromJson(file, Quote[].class);


//            System.out.println("Here is your quote: \n " + quoteArray[randInt]);
            int randInt = getRandomInt(quoteArray.length);

            String randomQ = quoteArray[randInt].toString();

            return randomQ;

        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Your filename is incorrect.";
        }
    }

    public static String connectToURL(String urlString) throws IOException {
        //https://www.tutorialspoint.com/how-to-read-parse-json-array-using-java
        List<QuoteAPI> quoteList = new ArrayList<>();
        Gson gson = new Gson();
        URL url = new URL(urlString);
        File filePath = new File ("src/main/resources/recentAPIQuotes.json");
        HttpURLConnection numConnection =  (HttpURLConnection) url.openConnection();

        //https://stackoverflow.com/questions/15927079/how-to-use-httpsurlconnection-through-proxy-by-setproperty
        numConnection.setRequestProperty("x-rapidapi-host", "andruxnet-random-famous-quotes.p.rapidapi.com");
        numConnection.setRequestProperty("x-rapidapi-key", "d79e3079c3msh3e8d2f540aea655p1433dfjsn0b281924b6fd");
        numConnection.setRequestMethod("GET");
        BufferedReader input = new BufferedReader(new InputStreamReader(numConnection.getInputStream()));
        StringBuilder quoteString = new StringBuilder();
        String firstLine = input.readLine();
        quoteString.append(firstLine);
        QuoteAPI[] quoteArray = gson.fromJson(quoteString.toString(), QuoteAPI[].class);
        QuoteAPI randomSingleQuote = quoteArray[0];
        quoteList.add(randomSingleQuote);
        System.out.println("quoteList = " + quoteList.toString());

        FileWriter apiWriter;
        try{
            apiWriter = new FileWriter("src/main/resources/recentAPIQuotes.json");
            gson.toJson(quoteList,apiWriter);
            apiWriter.close();

        } catch (IOException e){
            System.out.println("File is not Found");
        }
            return quoteArray[0].toString();
//              https://howtodoinjava.com/java/io/java-append-to-file/
//        else{
//            System.out.println("else");
//            FileWriter apiWriter;
//            try{
//                apiWriter = new FileWriter("src/main/resources/recentAPIQuotes.json");
//                BufferedWriter apiFile = new BufferedWriter(apiWriter);
//                apiFile.append('c');
////                apiFile.write("Example test");
////                gson.toJson(randomSingleQuote,apiWriter);
//                apiWriter.close();
//
//            } catch (IOException e){
//                System.out.println("File is not Found");
//            }
//            return quoteArray[0].toString();
//        }
//
    }

}
