package net.local.services.application.ports.persistence;

import java.util.List;
import java.util.Optional;

import net.local.services.application.domain.Book;

public interface LoadBookPort {
    List<Book> loadAll();
    Optional<Book> loadByIsbn(String isbn);
    Optional<Book> loadByTitle(String title);
}
