package com.example.project0002.model;


import jakarta.persistence.*;

@Entity
@Table(name = "KEHOACHMONHOM")
public class KeHoachMoNhom {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "hoc_phan_id", referencedColumnName = "id")
    private HocPhan hocPhan;

    @Column(name = "khoa")
    private String khoa;

    @Column(name = "so_sinh_vien")
    private int soSinhVien;

    @Column(name = "so_sinh_vien_mot_lop")
    private int soSinhVienMotLop;

    public KeHoachMoNhom() {}

    public KeHoachMoNhom(String id, HocPhan hocPhan, String khoa, int soSinhVien, int soSinhVienMotLop) {
        this.id = id;
        this.hocPhan = hocPhan;
        this.khoa = khoa;
        this.soSinhVien = soSinhVien;
        this.soSinhVienMotLop = soSinhVienMotLop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HocPhan getHocPhan() {
        return hocPhan;
    }

    public void setHocPhan(HocPhan hocPhan) {
        this.hocPhan = hocPhan;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public int getSoSinhVien() {
        return soSinhVien;
    }

    public void setSoSinhVien(int soSinhVien) {
        this.soSinhVien = soSinhVien;
    }

    public int getSoSinhVienMotLop() {
        return soSinhVienMotLop;
    }

    public void setSoSinhVienMotLop(int soSinhVienMotLop) {
        this.soSinhVienMotLop = soSinhVienMotLop;
    }
}
