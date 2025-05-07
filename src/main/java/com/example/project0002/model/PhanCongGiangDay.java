package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PHANCONGGIANGDAY")
public class PhanCongGiangDay {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id", referencedColumnName = "id")
    private GiangVien giangVien;

    @ManyToOne
    @JoinColumn(name = "ke_hoach_mo_nhom_id", referencedColumnName = "id")
    private KeHoachMoNhom keHoachMoNhom;

    @Column(name = "so_tiet")
    private int soTiet;

    @Column(name = "nhom")
    private int nhom;

    @Column(name = "hoc_ky")
    private int hocKy;

    public PhanCongGiangDay() {}

    public PhanCongGiangDay(String id, GiangVien giangVien, KeHoachMoNhom keHoachMoNhom, int soTiet, int nhom, int hocKy) {
        this.id = id;
        this.giangVien = giangVien;
        this.keHoachMoNhom = keHoachMoNhom;
        this.soTiet = soTiet;
        this.nhom = nhom;
        this.hocKy = hocKy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public KeHoachMoNhom getKeHoachMoNhom() {
        return keHoachMoNhom;
    }

    public void setKeHoachMoNhom(KeHoachMoNhom keHoachMoNhom) {
        this.keHoachMoNhom = keHoachMoNhom;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public int getNhom() {
        return nhom;
    }

    public void setNhom(int nhom) {
        this.nhom = nhom;
    }

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }
}