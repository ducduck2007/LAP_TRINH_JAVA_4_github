package com.example.assignment_gd2.dao;

import com.example.assignment_gd2.model.Book;
import com.example.assignment_gd2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class BookDAO {
    public List<Book> findAll(String keyword) {
        try (Session s = HibernateUtil.getSession()) {
            String hql = "from Book";
            if (keyword != null && !keyword.trim().isEmpty()) {
                hql += " where lower(title) like :kw or lower(author) like :kw";
            }
            Query<Book> q = s.createQuery(hql, Book.class);
            if (keyword != null && !keyword.trim().isEmpty()) {
                q.setParameter("kw", "%" + keyword.toLowerCase() + "%");
            }
            return q.list();
        }
    }

    public Book findById(Integer id) {
        try (Session s = HibernateUtil.getSession()) {
            return s.get(Book.class, id);
        }
    }

    public void saveOrUpdate(Book b) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            if (b.getId() == null) s.persist(b); else s.merge(b);
            tx.commit();
        } catch (Exception e) { if (tx != null) tx.rollback(); throw e; }
    }

    public void delete(Integer id) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            Book b = s.get(Book.class, id);
            if (b != null) s.remove(b);
            tx.commit();
        } catch (Exception e) { if (tx != null) tx.rollback(); throw e; }
    }
}
