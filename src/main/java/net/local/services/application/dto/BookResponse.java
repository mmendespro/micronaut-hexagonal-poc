package net.local.services.application.dto;

public class BookResponse {
    
    private final String bookIsbn;
    private final String bookTitle;
    private final String bookAuthor;

    public BookResponse(String bookIsbn, String bookTitle, String bookAuthor) {
        this.bookIsbn = bookIsbn;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

}
