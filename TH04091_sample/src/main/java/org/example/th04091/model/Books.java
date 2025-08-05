package org.example.th04091.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "books")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Integer bookID;

    @Column(name = "Title")
    private String title;

    @Column(name = "Author")
    private String author;

    @Column(name = "Category")
    private String category;

    @Column(name = "Publisher")
    private String publisher;

    @Column(name = "QuantityInStock")
    private Integer quantityInStock;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "IsAvailable")
    private Boolean isAvailable;

    @Column(name = "Summary")
    private String summary;

    @Temporal(TemporalType.DATE)
    @Column(name = "PublishedDate")
    private Date publishedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "ReturnDueDate")
    private Date returnDueDate;

    @Column(name = "CreatedAt")
    private LocalDate createdAt;

    @Column(name = "ISBN")
    private String isbn;

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Date getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(Date returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
