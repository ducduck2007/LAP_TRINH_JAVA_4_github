package org.example.demo4.repository;

import org.example.demo4.Hibernate;
import org.example.demo4.entity.LoaiSanPham;
import org.example.demo4.entity.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SanPhamRepository {
    public List<SanPham> findAll() {
        Session session = Hibernate.getSession();
        Query<SanPham> query = session.createQuery("select s from SanPham s left join fetch s.id_loai_sp order by s.id_san_pham desc", SanPham.class);
        List<SanPham> sanPhams = query.list();
        return sanPhams;
    }

    public SanPham create(SanPham sanPham) {
        Session session = Hibernate.getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(sanPham);
        transaction.commit();
        return sanPham;
    }

    public SanPham findById(Integer id) {
        Session session = Hibernate.getSession();
        return session.find(SanPham.class, id);
    }

    public SanPham update(SanPham sanPham) {
        Session session = Hibernate.getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(sanPham);
        transaction.commit();
        return sanPham;
    }

    public void delete(int id) {
        Session session = Hibernate.getSession();
        Transaction transaction = session.beginTransaction();
        SanPham sanPham = session.find(SanPham.class, id);
        if (sanPham != null) {
            session.remove(sanPham);
        }
        transaction.commit();
    }

    public List<SanPham> searchByTenSP(String ten_san_pham) {
        Session session = Hibernate.getSession();
        Query<SanPham> query = session.createQuery(
                "select s from SanPham s left join fetch s.id_loai_sp where s.ten_san_pham like :ten_san_pham", SanPham.class);
        query.setParameter("ten_san_pham", "%" + ten_san_pham + "%");
        List<SanPham> sanPhams = query.list();
        return sanPhams;
    }
}
