package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "KeHoachDayHoc_NganhHoc")
public class KeHoachDayHoc_NganhHoc {
    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "ke_hoach_day_hoc_id", referencedColumnName = "id")
    private KeHoachDayHoc keHoachDayHoc;

    @ManyToOne
    @JoinColumn(name = "nganh_hoc_id", referencedColumnName = "id")
    private NganhHoc nganhHoc;

    public KeHoachDayHoc_NganhHoc(String id, KeHoachDayHoc keHoachDayHoc, NganhHoc nganhHoc) {
        this.id = id;
        this.keHoachDayHoc = keHoachDayHoc;
        this.nganhHoc = nganhHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KeHoachDayHoc getKeHoachDayHoc() {
        return keHoachDayHoc;
    }

    public void setKeHoachDayHoc(KeHoachDayHoc keHoachDayHoc) {
        this.keHoachDayHoc = keHoachDayHoc;
    }

    public NganhHoc getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(NganhHoc nganhHoc) {
        this.nganhHoc = nganhHoc;
    }
}
