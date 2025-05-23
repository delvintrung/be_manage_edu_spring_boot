package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "HOCPHAN")
public class HocPhan {

    @Id
    @Column(name = "id")
    private String id;


    @Column(name = "ten")
    private String ten;

    @Column(name = "tin_chi")
    private String tinChi;

    @Column(name = "tiet_ly_thuyet")
    private int tietLyThuyet;

    @Column(name = "tiet_thuc_hanh")
    private int tietThucHanh;

    @ManyToOne()
    @JoinColumn(name = "nganh_hoc_id", referencedColumnName = "id")
    private NganhHoc nganhHoc;

    public HocPhan() {}

    public HocPhan(String id, String ten, String tinChi, int tietLyThuyet, int tietThucHanh, NganhHoc nganhHoc) {
        this.id = id;
        this.ten = ten;
        this.tinChi = tinChi;
        this.tietLyThuyet = tietLyThuyet;
        this.tietThucHanh = tietThucHanh;
        this.nganhHoc = nganhHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTinChi() {
        return tinChi;
    }

    public void setTinChi(String tinChi) {
        this.tinChi = tinChi;
    }

    public int getTietLyThuyet() {
        return tietLyThuyet;
    }

    public void setTietLyThuyet(int tietLyThuyet) {
        this.tietLyThuyet = tietLyThuyet;
    }

    public int getTietThucHanh() {
        return tietThucHanh;
    }

    public void setTietThucHanh(int tietThucHanh) {
        this.tietThucHanh = tietThucHanh;
    }

    public NganhHoc getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(NganhHoc nganhHoc) {
        this.nganhHoc = nganhHoc;
    }
}