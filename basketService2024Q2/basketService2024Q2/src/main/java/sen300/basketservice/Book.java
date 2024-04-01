package sen300.basketservice;

import java.time.LocalDate;
//import org.springframework.data.annotation.*;
import org.springframework.data.annotation.*;
//import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	// @Id
	// private long bookId;

	@Id
	private UUID bookGuid;

	private String title;

	private String description;

	private LocalDate publishedDate;

	private LocalDate createdDate;

	/*
	 * public long getBookId() {
	 * return bookId;
	 * }
	 * 
	 * public void setBookId(long bookId) {
	 * this.bookId = bookId;
	 * }
	 */

	public UUID getBookGuid() {
		return bookGuid;
	}

	public void setBookGuid(UUID bookUUID) {
		this.bookGuid = bookUUID;
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
