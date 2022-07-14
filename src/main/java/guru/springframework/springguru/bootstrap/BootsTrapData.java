package guru.springframework.springguru.bootstrap;

import guru.springframework.springguru.model.Artist;
import guru.springframework.springguru.model.Book;
import guru.springframework.springguru.repositories.ArtistRepository;
import guru.springframework.springguru.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsTrapData implements CommandLineRunner {

    private final ArtistRepository artistRepository;
    private final BookRepository bookRepository;

    public BootsTrapData(ArtistRepository artistRepository, BookRepository bookRepository) {
        this.artistRepository = artistRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Artist dan = new Artist("Dan", "Abnett");
        Book wh40k = new Book("Warhammer40k", "123123");

        dan.getBookList().add(wh40k);
        wh40k.getArtist().add(dan);

        artistRepository.save(dan);
        bookRepository.save(wh40k);

        Artist rob = new Artist("Rob", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "321321");
        rob.getBookList().add(noEJB);
        noEJB.getArtist().add(rob);

        artistRepository.save(rob);
        bookRepository.save(noEJB);

        System.out.println("Starting in BootsTrap");
        System.out.println("Number of Books : " + bookRepository.count());
    }
}
