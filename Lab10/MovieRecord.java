import java.util.LinkedList;
import java.util.Scanner;

public class MovieRecord {
    private String title;
    private int rating;

    MovieRecord(String t, int r) {
        title = t;
        rating = r;
    }

    public String getTitle() {
        return title;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        String s = title+"\t"+rating;
        return s;
    }

}
