package com.example.project0002.model;


import jakarta.persistence.*;

@Entity
@Table(name = "KHOIKIENTHUC_CHUONGTRINHKHUNG")
public class KhoiKienThuc_KhungChuongTrinh {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "khung_chuong_trinh_id", referencedColumnName = "id")
    private ChuongTrinhKhung khungChuongTrinh;

    @ManyToOne
    @JoinColumn(name = "khoi_kien_thuc_id", referencedColumnName = "id")
    private KhoiKienThuc khoiKienThuc;

    public KhoiKienThuc_KhungChuongTrinh(ChuongTrinhKhung khungChuongTrinh, KhoiKienThuc khoiKienThuc, String id) {
        this.khungChuongTrinh = khungChuongTrinh;
        this.khoiKienThuc = khoiKienThuc;
        this.id = id;
    }

    public KhoiKienThuc_KhungChuongTrinh() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KhoiKienThuc getKhoiKienThuc() {
        return khoiKienThuc;
    }

    public void setKhoiKienThuc(KhoiKienThuc khoiKienThuc) {
        this.khoiKienThuc = khoiKienThuc;
    }

    public ChuongTrinhKhung getKhungChuongTrinh() {
        return khungChuongTrinh;
    }

    public void setKhungChuongTrinh(ChuongTrinhKhung khungChuongTrinh) {
        this.khungChuongTrinh = khungChuongTrinh;
    }
}
