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
        book.setBookGuid(UUID.randomUUID());
        book.setCreatedDate(LocalDate.now());
        book.setPublishedDate(createRandomDate(1900, 2023));
        booksRepo.save(book);
    }

    @PostMapping(path = "/addbooks")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBooks(@RequestBody List<Book> books) {

        for (Book book : books) {
            book.setBookGuid(UUID.randomUUID());
            book.setCreatedDate(LocalDate.now());
            book.setPublishedDate(createRandomDate(1900, 2023));
            booksRepo.save(book);
        }
    }

    @GetMapping(path = "/search/{searchText}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Book> searchItems(@PathVariable(required = true) String searchText) {
        return booksRepo.findByTitleContainingOrDescriptionContaining(searchText, searchText);
    }

    @GetMapping(path = "/{bookUUID}")
    @ResponseStatus(code = HttpStatus.OK)
    public Book getBook(@PathVariable UUID bookUUID) {
        return booksRepo.findById(bookUUID).orElseThrow(() -> new NoSuchElementException());
    }

    @PutMapping(path = "/{bookUUID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@PathVariable(required = true) UUID bookUUID, @RequestBody Book book) {

        if (!book.getBookGuid().equals(bookUUID)) {
            throw new RuntimeException(
                    String.format("Path itemId %s did not match body itemId %s", bookUUID, book.getBookGuid()));
        }

        booksRepo.save(book);
    }

    @DeleteMapping(path = "/{bookUUID}")
    @ResponseStatus(HttpStatus.OK)
    public void DeleteItem(@PathVariable(required = true) UUID bookUUID) {

        booksRepo.deleteById(bookUUID);
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