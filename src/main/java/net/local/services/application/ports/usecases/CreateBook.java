package net.local.services.application.ports.usecases;

import net.local.services.application.dto.BookRequest;

public interface CreateBook {
    void createBook(BookRequest request);
}
