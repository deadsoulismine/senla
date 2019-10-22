public class Book {
    private String title;
    private String genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Book(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

}
