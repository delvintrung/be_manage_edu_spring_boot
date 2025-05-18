package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "COTDIEM")
public class CotDiem {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "de_cuong_id", referencedColumnName = "id")
    private DeCuongChiTiet deCuongChiTiet;

    @Column(name = "ten_cot_diem")
    private String tenCotDiem;

    @Column(name = "trong_so_danh_gia")
    private String trongSoDanhGia;

    @Column(name = "hinh_thuc_danh_gia")
    private String hinhThucDanhGia;
    public CotDiem() {}

    public CotDiem(String id, DeCuongChiTiet deCuongChiTiet, String tenCotDiem, String trongSoDanhGia, String hinhThucDanhGia) {
        this.id = id;
        this.deCuongChiTiet = deCuongChiTiet;
        this.tenCotDiem = tenCotDiem;
        this.trongSoDanhGia = trongSoDanhGia;
        this.hinhThucDanhGia = hinhThucDanhGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DeCuongChiTiet getDeCuongChiTiet() {
        return deCuongChiTiet;
    }

    public void setDeCuongChiTiet(DeCuongChiTiet deCuongChiTiet) {
        this.deCuongChiTiet = deCuongChiTiet;
    }

    public String getTenCotDiem() {
        return tenCotDiem;
    }

    public void setTenCotDiem(String tenCotDiem) {
        this.tenCotDiem = tenCotDiem;
    }

    public String getTrongSoDanhGia() {
        return trongSoDanhGia;
    }

    public void setTrongSoDanhGia(String trongSoDanhGia) {
        this.trongSoDanhGia = trongSoDanhGia;
    }

    public String getHinhThucDanhGia() {
        return hinhThucDanhGia;
    }

    public void setHinhThucDanhGia(String hinhThucDanhGia) {
        this.hinhThucDanhGia = hinhThucDanhGia;
    }
}
