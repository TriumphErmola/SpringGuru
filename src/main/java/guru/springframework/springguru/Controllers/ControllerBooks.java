package guru.springframework.springguru.Controllers;


import guru.springframework.springguru.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerBooks {

    private final BookRepository bookRepository;

    public ControllerBooks(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBook(Model model) {
        model.addAttribute("books", bookRepository.findAll());


        return "books/list";
    }
}
