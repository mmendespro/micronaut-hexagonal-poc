package net.local.services.application.dto;

public class BookRequest {
    
    private String bookTitle;
    private String bookAuthor;

    public BookRequest() {}

    public BookRequest(String bookTitle, String bookAuthor) {
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }
}
