package org.example.lab6.dao;

import org.example.lab6.model.User;
import org.example.democud.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDAOImpl implements UserDAO {

    @Override
    public void create(User user) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(User user) {
        Session session = HibernateUtil.getSession();
        try {
            session.beginTransaction();
            session.merge(user);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public User findByUsername(String username) {
        Session session = HibernateUtil.getSession();
        try {
            Query<User> query = session.createQuery("FROM User WHERE username = :username", User.class);
            query.setParameter("username", username);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }
}
