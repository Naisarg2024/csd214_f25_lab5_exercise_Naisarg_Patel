package ca.saultcollege.lab5.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BOOK")
public class BookEntity extends PublicationEntity {

    @Column
    private String author;

    @Column
    private String title;

    public BookEntity() {
        super();
    }

    public BookEntity(String name, double price, String publisher,
                      String author, String title) {
        super(name, price, publisher);
        this.author = author;
        this.title = title;
    }

    public BookEntity(String bookTitle, double price, String author, String bookTitle1) {
        super(bookTitle, price, bookTitle1);
        this.author = author;
    }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    @Override
    public String toString() {
        return "Book{" +
                super.toString() +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}