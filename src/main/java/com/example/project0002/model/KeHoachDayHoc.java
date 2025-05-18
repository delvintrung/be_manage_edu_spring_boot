package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "KEHOACHDAYHOC")
public class KeHoachDayHoc {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nganh_hoc_id")
    private String nganhHocId;

    @ManyToOne
    @JoinColumn(name = "hoc_phan_id", referencedColumnName = "id")
    private HocPhan hocPhan;

    @Column(name = "hoc_ky")
    private int hocKy;


    @ManyToOne
    @JoinColumn(name = "ma_hoc_phan_truoc", referencedColumnName = "id")
    private HocPhan hocPhanTruoc;

    public KeHoachDayHoc() {}

    public KeHoachDayHoc(String id, HocPhan hocPhan, int hocKy, int namHoc) {
        this.id = id;
        this.hocPhan = hocPhan;
        this.hocKy = hocKy;
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

    public int getHocKy() {
        return hocKy;
    }

    public void setHocKy(int hocKy) {
        this.hocKy = hocKy;
    }

    public HocPhan getHocPhanTruoc() {
        return hocPhanTruoc;
    }

    public String getNganhHocId() {
        return nganhHocId;
    }

    public void setNganhHocId(String nganhHocId) {
        this.nganhHocId = nganhHocId;
    }

    public void setHocPhanTruoc(HocPhan hocPhanTruoc) {
        this.hocPhanTruoc = hocPhanTruoc;
    }
}