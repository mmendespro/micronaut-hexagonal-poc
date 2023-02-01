package net.local.services.adapters.rest;

import java.util.List;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import net.local.services.application.dto.BookRequest;
import net.local.services.application.dto.BookResponse;
import net.local.services.application.ports.usecases.CreateBook;
import net.local.services.application.ports.usecases.ListAllBook;

@Controller("/books")
public class BookController {

    private final ListAllBook listAllBook;
    private final CreateBook createBook;

    public BookController(ListAllBook listAllBook, CreateBook createBook) {
        this.listAllBook = listAllBook;
        this.createBook = createBook;
    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Void> createBoot(BookRequest request) {
        createBook.createBook(request);
        return HttpResponse.ok(); 
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public HttpResponse<List<BookResponse>> getAll() {
        return HttpResponse.ok(listAllBook.listAllBooks());
    }
}