public class Book {
    private String book_id;
    private String book_name;
    private String author;
    private boolean is_Available =true;

    public Book() {
    }


    public Book(String book_id, String book_name, String author) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
    }

    public Book(String book_id, String book_name, String author, boolean is_Available) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.author = author;
        this.is_Available = is_Available;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isIs_Available() {
        return is_Available;
    }

    public void setIs_Available(boolean is_Available) {
        this.is_Available = is_Available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id='" + book_id + '\'' +
                ", book_name='" + book_name + '\'' +
                ", author='" + author + '\'' +
                ", is_Available=" + is_Available +
                '}';
    }
}
