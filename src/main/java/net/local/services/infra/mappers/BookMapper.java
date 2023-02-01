package net.local.services.infra.mappers;

import net.local.services.application.domain.Book;
import net.local.services.infra.persistence.entities.BookJPA;

public class BookMapper {
    
    public static BookJPA fromBook(Book book) {
        return new BookJPA(book.getIsbn(), book.getTitle(), book.getAuthor());
    }

    public static Book fromBookJPA(BookJPA bookJPA) {
        return new Book(bookJPA.getIsbn(), bookJPA.getTitle(), bookJPA.getAuthor());
    }
}
