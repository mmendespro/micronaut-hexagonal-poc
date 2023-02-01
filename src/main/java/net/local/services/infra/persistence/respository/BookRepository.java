package net.local.services.infra.persistence.respository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import net.local.services.application.domain.Book;
import net.local.services.application.ports.persistence.LoadBookPort;
import net.local.services.application.ports.persistence.SaveBookPort;
import net.local.services.infra.mappers.BookMapper;

public class BookRepository implements LoadBookPort, SaveBookPort {

    private final MySQLBookRepository repository;

    public BookRepository(MySQLBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Book book) {
        repository.save(BookMapper.fromBook(book));
    }

    @Override
    public List<Book> loadAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false).map(BookMapper::fromBookJPA).collect(Collectors.toList());
    }

    @Override
    public Optional<Book> loadByIsbn(String isbn) {
        var bookJPA = repository.findById(isbn);
        if(bookJPA.isPresent()) {
            return Optional.of(BookMapper.fromBookJPA(bookJPA.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> loadByTitle(String title) {
        var bookJPA = repository.findByTitle(title);
        if(bookJPA.isPresent()) {
            return Optional.of(BookMapper.fromBookJPA(bookJPA.get()));
        }
        return Optional.empty();
    }    
}
