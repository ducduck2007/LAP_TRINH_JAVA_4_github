package org.example.demo4.repository;

import org.example.demo4.Hibernate;
import org.example.demo4.entity.LoaiSanPham;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LoaiSanPhamRepository {
    public List<LoaiSanPham> findAll() {
        Session session = Hibernate.getSession();
        Query<LoaiSanPham> query = session.createQuery("from LoaiSanPham", LoaiSanPham.class);
        List<LoaiSanPham> loaiSanPhams = query.list();
        return loaiSanPhams;
    }

    public LoaiSanPham findById(Integer id) {
        Session session = Hibernate.getSession();
        return session.find(LoaiSanPham.class, id);
    }
}
