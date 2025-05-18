package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "COTDIEMCHITIET")
public class CotDiemChiTiet {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "de_cuong_id", referencedColumnName = "id")
    private DeCuongChiTiet deCuongChiTiet;

    @ManyToOne
    @JoinColumn(name = "cot_diem_id", referencedColumnName = "id")
    private CotDiem cotDiem;

    public CotDiemChiTiet() {}

    public CotDiemChiTiet(DeCuongChiTiet deCuongChiTiet, CotDiem cotDiem) {
        this.deCuongChiTiet = deCuongChiTiet;
        this.cotDiem = cotDiem;
    }

    public DeCuongChiTiet getDeCuongChiTiet() {
        return deCuongChiTiet;
    }

    public void setDeCuongChiTiet(DeCuongChiTiet deCuongChiTiet) {
        this.deCuongChiTiet = deCuongChiTiet;
    }

    public CotDiem getCotDiem() {
        return cotDiem;
    }

    public void setCotDiem(CotDiem cotDiem) {
        this.cotDiem = cotDiem;
    }
}