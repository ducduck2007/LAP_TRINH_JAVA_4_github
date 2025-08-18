package org.example.demo4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loai_sp")
public class LoaiSanPham {
    @Id
    @Column(name = "id")
    private int id_loai_san_pham;

    @Column(name = "ma")
    private String ma_loai_san_pham;

    @Column(name = "ten")
    private String ten_loai_san_pham;

    public int getId_loai_san_pham() {
        return id_loai_san_pham;
    }

    public void setId_loai_san_pham(int id_loai_san_pham) {
        this.id_loai_san_pham = id_loai_san_pham;
    }

    public String getMa_loai_san_pham() {
        return ma_loai_san_pham;
    }

    public void setMa_loai_san_pham(String ma_loai_san_pham) {
        this.ma_loai_san_pham = ma_loai_san_pham;
    }

    public String getTen_loai_san_pham() {
        return ten_loai_san_pham;
    }

    public void setTen_loai_san_pham(String ten_loai_san_pham) {
        this.ten_loai_san_pham = ten_loai_san_pham;
    }
}
