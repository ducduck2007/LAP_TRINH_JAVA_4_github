package org.example.demo1.repository;

import org.example.demo1.Hibernate;
import org.example.demo1.entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SanPhamRepos {

    public List<SanPham> getAll() {
        Session session = Hibernate.getSession();
        Query<SanPham> query = session.createQuery(
                "select sp from SanPham sp left join fetch sp.idLoaiSp",
                SanPham.class
        );
        return query.list();
    }

    public SanPham getById(Integer id) {
        Session session = Hibernate.getSession();
        return session.find(SanPham.class, id);
    }

    public SanPham create(SanPham sanPham) {
        Session session = Hibernate.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(sanPham);
        transaction.commit();
        return sanPham;
    }

    public SanPham update(SanPham sanPham) {
        Session session = Hibernate.getSession();
        Transaction tx = session.beginTransaction();
        session.merge(sanPham);
        tx.commit();
        return sanPham;
    }

    public void deleteById(int id) {
        Session session = Hibernate.getSession();
        Transaction tx = session.beginTransaction();
        SanPham sp = session.find(SanPham.class, id);
        if (sp != null) {
            session.remove(sp);
        }
        tx.commit();
    }

    public List<SanPham> searchByTen(String ten) {
        Session session = Hibernate.getSession();
        Query<SanPham> query = session.createQuery(
                "select sp from SanPham sp left join fetch sp.idLoaiSp where sp.ten like :ten",
                SanPham.class
        );
        query.setParameter("ten", "%" + ten + "%");
        return query.list();
    }
}
