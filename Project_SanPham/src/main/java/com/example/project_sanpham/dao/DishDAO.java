package com.example.project_sanpham.dao;

import com.example.project_sanpham.entity.Dish;
import com.example.project_sanpham.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DishDAO {
    public List<Dish> findAll() {
        try (Session s = HibernateUtil.getSession()) {
            return s.createQuery("from Dish", Dish.class).getResultList();
        }
    }

    public Dish findById(Integer id) {
        try (Session s = HibernateUtil.getSession()) {
            return s.get(Dish.class, id);
        }
    }

    public void save(Dish d) {
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

    public void update(Dish d) {
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
            Dish d = s.get(Dish.class, id);
            if (d != null) s.remove(d);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}