package guru.springframework.springguru.repositories;

import guru.springframework.springguru.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
