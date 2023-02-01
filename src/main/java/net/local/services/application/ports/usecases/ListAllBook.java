package net.local.services.application.ports.usecases;

import java.util.List;

import net.local.services.application.dto.BookResponse;

public interface ListAllBook {
    List<BookResponse> listAllBooks();
}
