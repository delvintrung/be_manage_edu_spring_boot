package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "NHOMHOC")
public class NhomHoc {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "ke_hoach_mo_nhom_id", referencedColumnName = "id")
    private KeHoachMoNhom keHoachMoNhom;

    @ManyToOne
    @JoinColumn(name = "giang_vien_id", referencedColumnName = "id")
    private GiangVien giangVien;

    @Column(name = "ma_nhom")
    private int maNhom;

    @Column(name = "so_sinh_vien")
    private int soSinhVien;

    public NhomHoc() {}

    public NhomHoc(String id, KeHoachMoNhom keHoachMoNhom, GiangVien giangVien, int maNhom, int soSinhVien) {
        this.id = id;
        this.keHoachMoNhom = keHoachMoNhom;
        this.giangVien = giangVien;
        this.maNhom = maNhom;
        this.soSinhVien = soSinhVien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KeHoachMoNhom getKeHoachMoNhom() {
        return keHoachMoNhom;
    }

    public void setKeHoachMoNhom(KeHoachMoNhom keHoachMoNhom) {
        this.keHoachMoNhom = keHoachMoNhom;
    }

    public GiangVien getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(GiangVien giangVien) {
        this.giangVien = giangVien;
    }

    public int getMaNhom() {
        return maNhom;
    }

    public void setMaNhom(int maNhom) {
        this.maNhom = maNhom;
    }

    public int getSoSinhVien() {
        return soSinhVien;
    }

    public void setSoSinhVien(int soSinhVien) {
        this.soSinhVien = soSinhVien;
    }
}