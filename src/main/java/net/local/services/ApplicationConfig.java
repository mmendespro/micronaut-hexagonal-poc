package net.local.services;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import net.local.services.application.ports.persistence.IsbnGenerator;
import net.local.services.application.services.BookManagerService;
import net.local.services.infra.persistence.generators.UuidIsbnGenerator;
import net.local.services.infra.persistence.respository.BookRepository;
import net.local.services.infra.persistence.respository.MySQLBookRepository;

@Factory
public class ApplicationConfig {
    
    @Bean
    public IsbnGenerator uuidIsbnGenerator() {
        return new UuidIsbnGenerator();
    }

    @Bean
    public BookRepository bookRepository(MySQLBookRepository repo) {
        return new BookRepository(repo);
    }

    @Bean
    public BookManagerService bookManagerService(IsbnGenerator isbnGenerator, BookRepository repo) {
        return new BookManagerService(isbnGenerator, repo, repo);
    }
}
