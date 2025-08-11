package com.example.assignment_gd2.dao;

import com.example.assignment_gd2.model.Book;
import com.example.assignment_gd2.model.BorrowRequest;
import com.example.assignment_gd2.model.User;
import com.example.assignment_gd2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class BorrowRequestDAO {
    public void create(User user, Book book) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            BorrowRequest br = new BorrowRequest();
            br.setUser(s.get(User.class, user.getId()));
            br.setBook(s.get(Book.class, book.getId()));
            br.setStatus("PENDING");
            s.persist(br);
            tx.commit();
        } catch (Exception e) { if (tx != null) tx.rollback(); throw e; }
    }

    public List<BorrowRequest> findByUser(Integer userId) {
        try (Session s = HibernateUtil.getSession()) {
            String hql = "from BorrowRequest br join fetch br.book where br.user.id = :uid order by br.requestDate desc";
            Query<BorrowRequest> q = s.createQuery(hql, BorrowRequest.class);
            q.setParameter("uid", userId);
            return q.list();
        }
    }

    public List<BorrowRequest> findAll() {
        try (Session s = HibernateUtil.getSession()) {
            String hql = "from BorrowRequest br join fetch br.user join fetch br.book order by br.requestDate desc";
            return s.createQuery(hql, BorrowRequest.class).list();
        }
    }

    public void updateStatus(Integer reqId, String status) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            BorrowRequest br = s.get(BorrowRequest.class, reqId);
            if (br != null) {
                br.setStatus(status);
                s.merge(br);
            }
            tx.commit();
        } catch (Exception e) { if (tx != null) tx.rollback(); throw e; }
    }
}
