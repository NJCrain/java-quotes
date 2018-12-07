public class Quote {
    protected String author;
    protected String text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String toString() {
        return text + " - " + author;
    }
}
