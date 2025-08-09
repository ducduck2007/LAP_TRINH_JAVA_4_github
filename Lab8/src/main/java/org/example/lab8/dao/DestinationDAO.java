package org.example.lab8.dao;

import org.example.lab8.entity.Destination;
import org.example.lab8.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DestinationDAO {
    public List<Destination> findAll() {
        try (Session s = HibernateUtil.getSession()) {
            return s.createQuery("from Destination", Destination.class).getResultList();
        }
    }

    public Destination findById(Integer id) {
        try (Session s = HibernateUtil.getSession()) {
            return s.get(Destination.class, id);
        }
    }

    public void save(Destination d) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            s.persist(d);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void update(Destination d) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            s.merge(d);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public void delete(Integer id) {
        Transaction tx = null;
        try (Session s = HibernateUtil.getSession()) {
            tx = s.beginTransaction();
            Destination d = s.get(Destination.class, id);
            if (d != null) s.remove(d);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}