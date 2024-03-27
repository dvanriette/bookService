package sen300.bookservice.SEN300BookServiceAPI;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.*;

import com.fasterxml.jackson.annotation.*;

public class Book {

    @Id
    private UUID bookGuid;
    private String title;
    private String description;
    private LocalDate publishedDate;
    private LocalDate createdDate;

    public UUID getBookGuid() {
        return bookGuid;
    }

    public void setBookGuid(UUID BookGuid) {
        this.bookGuid = BookGuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}