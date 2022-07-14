package guru.springframework.springguru.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String isbn;
    @ManyToMany
    @JoinTable(name = "artist_book",joinColumns = @JoinColumn(name ="book_id"),
    inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artist;

    public Book() {
    }

    public Book(String name, String isbn, Set<Artist> artist) {
        this.name = name;
        this.isbn = isbn;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Set<Artist> getArtist() {
        return artist;
    }

    public void setArtist(Set<Artist> artist) {
        this.artist = artist;
    }
}
