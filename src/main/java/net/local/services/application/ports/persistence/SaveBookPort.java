package net.local.services.application.ports.persistence;

import net.local.services.application.domain.Book;

public interface SaveBookPort {
    void save(Book book);
}
