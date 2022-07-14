package guru.springframework.springguru.repositories;

import guru.springframework.springguru.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
