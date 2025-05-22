package com.example.project0002.model;


import jakarta.persistence.*;

@Entity
@Table(name = "KhoiKienThuc_KeHoachDayHoc")
public class KhoiKienThuc_KeHoachDayHoc {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "khoi_kien_thuc_id", referencedColumnName = "id")
    private KhoiKienThuc khoiKienThuc;

    @ManyToOne
    @JoinColumn(name = "ke_hoach_day_hoc_id", referencedColumnName = "id")
    private KeHoachDayHoc keHoachDayHoc;

    public KhoiKienThuc_KeHoachDayHoc(String id, KhoiKienThuc khoiKienThuc,KeHoachDayHoc keHoachDayHoc) {
        this.id = id;
        this.khoiKienThuc = khoiKienThuc;
        this.keHoachDayHoc = keHoachDayHoc;
    }

    public KhoiKienThuc_KeHoachDayHoc() {

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

    public KeHoachDayHoc getKeHoachDayHoc() {
        return keHoachDayHoc;
    }

    public void setKeHoachDayHoc(KeHoachDayHoc keHoachDayHoc) {
        this.keHoachDayHoc = keHoachDayHoc;
    }
}
