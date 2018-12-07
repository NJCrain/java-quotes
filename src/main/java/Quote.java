import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Quote {
    protected String author;
    protected String text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    //Static method to read in the json file of quotes and return it as an ArrayList of Quote objects
    public static ArrayList<Quote> quoteList() {
        try {
            byte[] text = Files.readAllBytes(Paths.get("assets/recentquotes.json"));
            Gson gson = new Gson();
            //The whole TypeToken thing was the suggestion from https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            ArrayList<Quote> quotes = gson.fromJson(new String(text), new TypeToken<ArrayList<Quote>>(){}.getType());
            return quotes;

        }
        catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    //Static method that will get and return a random Ron Swanson quote
    public static Quote getWebQuote() {
        try {
            URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            //Used from the example found at https://www.baeldung.com/java-http-request
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            Quote quote = new Quote("Ron Swanson", content.deleteCharAt(0).deleteCharAt(content.length() -1 ).toString());
            in.close();
            return quote;
        }
        catch (IOException e) {
            System.out.println("Couldn't connect to the internet, getting a local quote instead");
        }
        return null;
    }

    //Instance method that will add the quote it is called on to the provided ArrayList of quotes and save that List to the recentquotes.json file
    public void saveQuote(ArrayList<Quote> quotes) {
        Gson gson = new Gson();
        quotes.add(this);
        if (!quotes.contains(this)) {
            try {
                FileWriter jsonQuotes = new FileWriter("assets/recentquotes.json");
                jsonQuotes.write(gson.toJson(quotes));
                jsonQuotes.close();
            } catch (IOException e) {
                System.out.println("Something went wrong while trying to save the quote");
                System.err.println(e);
            }
        }
    }

    public String toString() {
        return text + " - " + author;
    }
}
