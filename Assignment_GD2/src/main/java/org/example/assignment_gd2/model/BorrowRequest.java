package com.example.assignment_gd2.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BorrowRequests")
public class BorrowRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BookId", nullable = false)
    private Book book;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RequestDate")
    private Date requestDate;

    @Column(name = "Status", nullable = false, length = 10)
    private String status; // PENDING | APPROVED | REJECTED

    @PrePersist
    public void prePersist() {
        if (requestDate == null) requestDate = new Date();
        if (status == null) status = "PENDING";
    }

    // getters/setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public Date getRequestDate() { return requestDate; }
    public void setRequestDate(Date requestDate) { this.requestDate = requestDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
