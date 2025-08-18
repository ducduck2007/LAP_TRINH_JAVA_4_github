package org.example.demo4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id_san_pham;

    @Column(name = "ma")
    private String ma_san_pham;

    @Column(name = "ten")
    private String ten_san_pham;

    @Column(name = "mota")
    private String mota_san_pham;

    @Column(name = "website")
    private String website_san_pham;

    @Column(name = "gia_ban")
    private int gia_ban_san_pham;

    @Column(name = "so_luong")
    private int so_luong_san_pham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_loai_sp")
    private LoaiSanPham id_loai_sp;

    @Column(name = "trang_thai")
    private int trang_thai_san_pham;

    public SanPham() {
    }

    public SanPham(Integer id_san_pham, String ma_san_pham, String ten_san_pham, String mota_san_pham, String website_san_pham, int gia_ban_san_pham, int so_luong_san_pham, LoaiSanPham id_loai_sp, int trang_thai_san_pham) {
        this.id_san_pham = id_san_pham;
        this.ma_san_pham = ma_san_pham;
        this.ten_san_pham = ten_san_pham;
        this.mota_san_pham = mota_san_pham;
        this.website_san_pham = website_san_pham;
        this.gia_ban_san_pham = gia_ban_san_pham;
        this.so_luong_san_pham = so_luong_san_pham;
        this.id_loai_sp = id_loai_sp;
        this.trang_thai_san_pham = trang_thai_san_pham;
    }

    public Integer getId_san_pham() {
        return id_san_pham;
    }

    public void setId_san_pham(Integer id_san_pham) {
        this.id_san_pham = id_san_pham;
    }

    public String getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(String ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public String getTen_san_pham() {
        return ten_san_pham;
    }

    public void setTen_san_pham(String ten_san_pham) {
        this.ten_san_pham = ten_san_pham;
    }

    public String getMota_san_pham() {
        return mota_san_pham;
    }

    public void setMota_san_pham(String mota_san_pham) {
        this.mota_san_pham = mota_san_pham;
    }

    public String getWebsite_san_pham() {
        return website_san_pham;
    }

    public void setWebsite_san_pham(String website_san_pham) {
        this.website_san_pham = website_san_pham;
    }

    public int getGia_ban_san_pham() {
        return gia_ban_san_pham;
    }

    public void setGia_ban_san_pham(int gia_ban_san_pham) {
        this.gia_ban_san_pham = gia_ban_san_pham;
    }

    public int getSo_luong_san_pham() {
        return so_luong_san_pham;
    }

    public void setSo_luong_san_pham(int so_luong_san_pham) {
        this.so_luong_san_pham = so_luong_san_pham;
    }

    public LoaiSanPham getId_loai_sp() {
        return id_loai_sp;
    }

    public void setId_loai_sp(LoaiSanPham id_loai_sp) {
        this.id_loai_sp = id_loai_sp;
    }

    public int getTrang_thai_san_pham() {
        return trang_thai_san_pham;
    }

    public void setTrang_thai_san_pham(int trang_thai_san_pham) {
        this.trang_thai_san_pham = trang_thai_san_pham;
    }
}
