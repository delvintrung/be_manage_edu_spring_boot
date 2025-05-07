package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "THONGTINCHUNG_CTDT")
public class ThongTinChungCTDT {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "chuong_trinh_dao_tao_id", referencedColumnName = "id")
    private ChuongTrinhDaoTao chuongTrinhDaoTao;

    @ManyToOne
    @JoinColumn(name = "nganh_hoc_id", referencedColumnName = "id")
    private NganhHoc nganhHoc;

    @Column(name = "loai_bang")
    private String loaiBang;

    @Column(name = "loai_hinh_dao_tao")
    private String loaiHinhDaoTao;

    @Column(name = "ngon_ngu_dao_tao")
    private String ngonNguDaoTao;

    public ThongTinChungCTDT() {}

    public ThongTinChungCTDT(String id, ChuongTrinhDaoTao chuongTrinhDaoTao, NganhHoc nganhHoc,
                             String loaiBang, String loaiHinhDaoTao, String ngonNguDaoTao) {
        this.id = id;
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
        this.nganhHoc = nganhHoc;
        this.loaiBang = loaiBang;
        this.loaiHinhDaoTao = loaiHinhDaoTao;
        this.ngonNguDaoTao = ngonNguDaoTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ChuongTrinhDaoTao getChuongTrinhDaoTao() {
        return chuongTrinhDaoTao;
    }

    public void setChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) {
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
    }

    public NganhHoc getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(NganhHoc nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getLoaiBang() {
        return loaiBang;
    }

    public void setLoaiBang(String loaiBang) {
        this.loaiBang = loaiBang;
    }

    public String getLoaiHinhDaoTao() {
        return loaiHinhDaoTao;
    }

    public void setLoaiHinhDaoTao(String loaiHinhDaoTao) {
        this.loaiHinhDaoTao = loaiHinhDaoTao;
    }

    public String getNgonNguDaoTao() {
        return ngonNguDaoTao;
    }

    public void setNgonNguDaoTao(String ngonNguDaoTao) {
        this.ngonNguDaoTao = ngonNguDaoTao;
    }
}