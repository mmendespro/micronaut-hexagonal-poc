package net.local.services.application.services;

import java.util.List;
import java.util.stream.Collectors;

import net.local.services.application.domain.Book;
import net.local.services.application.dto.BookRequest;
import net.local.services.application.dto.BookResponse;
import net.local.services.application.ports.persistence.IsbnGenerator;
import net.local.services.application.ports.persistence.LoadBookPort;
import net.local.services.application.ports.persistence.SaveBookPort;
import net.local.services.application.ports.usecases.CreateBook;
import net.local.services.application.ports.usecases.ListAllBook;

public class BookManagerService implements CreateBook, ListAllBook {
    
    private final IsbnGenerator isbnGenerator;
    private final LoadBookPort loadBookPort;
    private final SaveBookPort saveBookPort;

    public BookManagerService(IsbnGenerator isbnGenerator, LoadBookPort loadBookPort, SaveBookPort saveBookPort) {
        this.isbnGenerator = isbnGenerator;
        this.loadBookPort = loadBookPort;
        this.saveBookPort = saveBookPort;
    }

    @Override
    public void createBook(BookRequest request) {
        if(loadBookPort.loadByTitle(request.getBookTitle()).isPresent()) {
            throw new RuntimeException("Book already exists");
        }
        var book = new Book(isbnGenerator.generate(), request.getBookTitle(), request.getBookAuthor());
        saveBookPort.save(book);
    }

    @Override
    public List<BookResponse> listAllBooks() {
        return loadBookPort.loadAll()
                           .stream()
                           .map(book -> new BookResponse(book.getIsbn(), book.getTitle(), book.getAuthor()))
                           .collect(Collectors.toList());
    }
}
