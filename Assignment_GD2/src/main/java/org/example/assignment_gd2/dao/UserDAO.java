package com.example.assignment_gd2.dao;

import com.example.assignment_gd2.model.User;
import com.example.assignment_gd2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAO {
    public User findByEmail(String email) {
        try (Session s = HibernateUtil.getSession()) {
            Query<User> q = s.createQuery("from User where email = :e", User.class);
            q.setParameter("e", email);
            return q.uniqueResult();
        }
    }

    public void save(User u) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            s.persist(u);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
