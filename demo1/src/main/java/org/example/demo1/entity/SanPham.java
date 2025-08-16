package org.example.demo1.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mota")
    private String mota;

    @Column(name = "website")
    private String website;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;

    @Column(name = "so_luong")
    private int soLuong;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_loai_sp")
    private LoaiSanPham idLoaiSp;

    @Column(name = "trang_thai")
    private int trangThai;

    public SanPham() {
    }

    public SanPham(Integer id, String ma, String ten, String mota, LoaiSanPham idLoaiSp) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.mota = mota;
        this.idLoaiSp = idLoaiSp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public LoaiSanPham getIdLoaiSp() {
        return idLoaiSp;
    }

    public void setIdLoaiSp(LoaiSanPham idLoaiSp) {
        this.idLoaiSp = idLoaiSp;
    }
}
