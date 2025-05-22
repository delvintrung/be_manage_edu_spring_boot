package com.example.project0002.model;

import jakarta.persistence.*;


@Entity
@Table(name = "CHUONGTRINHKHUNG")
public class ChuongTrinhKhung {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "nganh_id", referencedColumnName = "id")
    private NganhHoc nganhHoc;

    public ChuongTrinhKhung(String id, NganhHoc nganhHoc) {
        this.id = id;
        this.nganhHoc = nganhHoc;
    }

    public ChuongTrinhKhung() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NganhHoc getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(NganhHoc nganhHoc) {
        this.nganhHoc = nganhHoc;
    }
}
