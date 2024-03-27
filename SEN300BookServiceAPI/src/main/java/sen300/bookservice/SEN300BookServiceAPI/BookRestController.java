package sen300.bookservice.SEN300BookServiceAPI;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/book")
public class BookRestController {

    @Autowired
    private BookRepository booksRepo;

    @GetMapping(path = "/test")
    @ResponseStatus(code = HttpStatus.OK)
    public String TestRest() {
        return "hello world";
    }

    @GetMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Book> findAllBooks() {
        return booksRepo.findAll();
    }
    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBook(@RequestBody Book book) {
        // item.setBookId(item.getBookId()); // why doesn't it do it automatically from
        // the json - is it due to AUTO?
        // System.out.println(item.getPublishedDate());
        book.setBookGuid(UUID.randomUUID());
        book.setCreatedDate(LocalDate.now());
        book.setPublishedDate(createRandomDate(1900, 2023));
        booksRepo.save(book);
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    private static LocalDate createRandomDate(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return LocalDate.of(year, month, day);
    }
}