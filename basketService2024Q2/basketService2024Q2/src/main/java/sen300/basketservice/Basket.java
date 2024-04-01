package sen300.basketservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.annotation.Id;

public class Basket implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private String basketGuid;
    private List<Book> books = new ArrayList<>();

    public Basket() {
    }

    public Basket(String id) {
        this.setBasketGuid(id);
    }

    public String getBasketGuid() {
        return basketGuid;
    }

    public void setBasketGuid(String basketId) {
        this.basketGuid = basketId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
