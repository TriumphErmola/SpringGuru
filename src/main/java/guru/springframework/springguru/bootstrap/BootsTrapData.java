package guru.springframework.springguru.bootstrap;

import guru.springframework.springguru.model.Artist;
import guru.springframework.springguru.model.Book;
import guru.springframework.springguru.model.Publisher;
import guru.springframework.springguru.repositories.ArtistRepository;
import guru.springframework.springguru.repositories.BookRepository;
import guru.springframework.springguru.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsTrapData implements CommandLineRunner {

    private final ArtistRepository artistRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootsTrapData(ArtistRepository artistRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.artistRepository = artistRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Starting in BootsTrap");
        Publisher publisher = new Publisher();
        publisher.setName("BFG Publishing");
        publisher.setCity("Hell");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Artist dan = new Artist("Dan", "Abnett");
        Book wh40k = new Book("Warhammer40k", "123123");

        dan.getBookList().add(wh40k);
        wh40k.getArtist().add(dan);

        wh40k.setPublisher(publisher);
        publisher.getBooks().add(wh40k);

        artistRepository.save(dan);
        bookRepository.save(wh40k);
        publisherRepository.save(publisher);

        Artist rob = new Artist("Rob", "Johnson");
        Book noEJB = new Book("J2EE development without EJB", "321321");
        rob.getBookList().add(noEJB);
        noEJB.getArtist().add(rob);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        artistRepository.save(rob);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);


        System.out.println("Number of Books : " + bookRepository.count());
        System.out.println("Publisher Number of Books :"+ publisher.getBooks().size());
    }
}
