package org.example.demo1.repository;

import org.example.demo1.Hibernate;
import org.example.demo1.entity.LoaiSanPham;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LoaiSanPhamRepos {
    public List<LoaiSanPham> getAll() {
        Session session = Hibernate.getSession();
        Query query = session.createQuery("from LoaiSanPham", LoaiSanPham.class);
        List<LoaiSanPham> loaiSanPhams = query.list();
        return loaiSanPhams;
    }

    public LoaiSanPham getById(int id) {
        Session session = Hibernate.getSession();
        return session.find(LoaiSanPham.class, id);
    }
}
