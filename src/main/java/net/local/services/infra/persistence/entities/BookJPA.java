package net.local.services.infra.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class BookJPA {

    @Id
    @Column(name="PK_ISBN", nullable=false)
    private String isbn;

    @Column(name="DS_TITLE", nullable=false)
    private String title;

    @Column(name="DS_AUTHOR", nullable=false)
    private String author;

    public BookJPA() {
    }

    public BookJPA(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
