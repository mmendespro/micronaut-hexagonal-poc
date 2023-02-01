package net.local.services.infra.persistence.respository;

import java.util.Optional;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import net.local.services.infra.persistence.entities.BookJPA;

@Repository
public interface H2BookRepository extends CrudRepository<BookJPA, String>{

    Optional<BookJPA> findByTitle(String title);
}
