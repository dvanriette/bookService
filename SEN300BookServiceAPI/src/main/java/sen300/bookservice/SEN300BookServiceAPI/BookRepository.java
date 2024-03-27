package sen300.bookservice.SEN300BookServiceAPI;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, UUID> {

    public List<Book> findByTitleContainingOrDescriptionContaining(String txt, String txt2);

}
