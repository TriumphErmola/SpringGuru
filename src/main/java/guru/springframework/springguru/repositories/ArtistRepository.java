package guru.springframework.springguru.repositories;

import guru.springframework.springguru.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface ArtistRepository extends CrudRepository<Artist,Long> {
}
