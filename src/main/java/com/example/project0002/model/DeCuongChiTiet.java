package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "DECUONGCHITIET")
public class DeCuongChiTiet {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "hoc_phan_id", referencedColumnName = "id")
    private HocPhan hocPhan;

    public DeCuongChiTiet() {}

    public DeCuongChiTiet(String id, HocPhan hocPhan) {
        this.id = id;
        this.hocPhan = hocPhan;
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

}