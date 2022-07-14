package guru.springframework.springguru.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String secondName;

    @ManyToMany(mappedBy = "artist")
    private Set<Book> bookList;

    public Artist() {
    }


    public Artist(String name, String secondName, Set<Book> bookList) {

        this.name = name;
        this.secondName = secondName;
        this.bookList = bookList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Set<Book> getBookList() {
        return bookList;
    }

    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }
}
