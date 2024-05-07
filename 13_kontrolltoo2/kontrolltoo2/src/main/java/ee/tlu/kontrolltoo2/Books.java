package ee.tlu.kontrolltoo2;

import java.util.ArrayList;

public class Books {
    public int id;
    public String title;
    public String author;
    public Object publication_year;
    public ArrayList<String> genre;
    public String description;
    public String cover_image;

    public Object getPublication_year() {
        return publication_year;
    }

}
