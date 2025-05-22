package com.example.project0002.model;

import jakarta.persistence.*;

@Entity
@Table(name = "KHOIKIENTHUC")
public class KhoiKienThuc {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "kcl_id", referencedColumnName = "id")
    private ChuongTrinhDaoTao chuongTrinhDaoTao;

    @ManyToOne
    @JoinColumn(name = "khoi_kien_thuc_cha", referencedColumnName = "id")
    private KhoiKienThuc khoiKienThucCha;

    @Column(name = "ten")
    private String ten;

    @Column(name = "so_tin_chi")
    private Integer soTinChi;

    @Column(name = "tin_chi_bat_buoc")
    private Integer tinChiBatBuoc;

    @Column(name = "tin_chi_tu_chon")
    private Integer tinChiTuChon;

    public KhoiKienThuc() {
        this.soTinChi = 0;
        this.tinChiBatBuoc = 0;
        this.tinChiTuChon = 0;
    }

    public KhoiKienThuc(String id, ChuongTrinhDaoTao chuongTrinhDaoTao, String ten, int soTinChi, int tinChiBatBuoc, int tinChiTuChon) {
        this.id = id;
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
        this.ten = ten;
        this.soTinChi = soTinChi;
        this.tinChiBatBuoc = tinChiBatBuoc;
        this.tinChiTuChon = tinChiTuChon;
    }

    public KhoiKienThuc(String id, int tinChiTuChon, int tinChiBatBuoc, int soTinChi, String ten, KhoiKienThuc khoiKienThucCha, ChuongTrinhDaoTao chuongTrinhDaoTao) {
        this.id = id;
        this.tinChiTuChon = tinChiTuChon;
        this.tinChiBatBuoc = tinChiBatBuoc;
        this.soTinChi = soTinChi;
        this.ten = ten;
        this.khoiKienThucCha = khoiKienThucCha;
        this.chuongTrinhDaoTao = chuongTrinhDaoTao;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Integer getTinChiBatBuoc() {
        return tinChiBatBuoc != null ? tinChiBatBuoc : 0;
    }

    public void setTinChiBatBuoc(Integer tinChiBatBuoc) {
        this.tinChiBatBuoc = tinChiBatBuoc != null ? tinChiBatBuoc : 0;
    }

    public Integer getTinChiTuChon() {
        return tinChiTuChon != null ? tinChiTuChon : 0;
    }

    public void setTinChiTuChon(Integer tinChiTuChon) {
        this.tinChiTuChon = tinChiTuChon != null ? tinChiTuChon : 0;
    }

    public Integer getSoTinChi() {
        return soTinChi != null ? soTinChi : 0;
    }

    public void setSoTinChi(Integer soTinChi) {
        this.soTinChi = soTinChi != null ? soTinChi : 0;
    }

    public KhoiKienThuc getKhoiKienThucCha() {
        return khoiKienThucCha;
    }

    public void setKhoiKienThucCha(KhoiKienThuc khoiKienThucCha) {
        this.khoiKienThucCha = khoiKienThucCha;
    }
}