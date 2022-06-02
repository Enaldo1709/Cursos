package library.models;

public class Book {
    private Author author;
    public Book(Author author) {
        this.author = author;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
}
