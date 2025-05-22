package com.example.project0002.service;

import com.example.project0002.model.KhoiKienThuc;
import com.example.project0002.model.ChuongTrinhDaoTao;
import com.example.project0002.repository.NhomKienThucRepository;
import com.example.project0002.repository.ChuongTrinhDaoTaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoiKienThucService {

    @Autowired
    private NhomKienThucRepository nhomKienThucRepository;

    @Autowired
    private ChuongTrinhDaoTaoRepository chuongTrinhDaoTaoRepository;

    // Create
    public KhoiKienThuc createNhomKienThuc(KhoiKienThuc nhomKienThuc) {
        Optional<KhoiKienThuc> existingNhomKienThuc = nhomKienThucRepository.findByTen(nhomKienThuc.getTen());
        if (existingNhomKienThuc.isPresent()) {
            throw new IllegalArgumentException("Nhóm kiến thức với tên " + nhomKienThuc.getTen() + " đã tồn tại!");
        }


        ChuongTrinhDaoTao chuongTrinhDaoTao = chuongTrinhDaoTaoRepository.findById(nhomKienThuc.getChuongTrinhDaoTao().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy chương trình đào tạo với ID: " + nhomKienThuc.getChuongTrinhDaoTao().getId()));
        nhomKienThuc.setChuongTrinhDaoTao(chuongTrinhDaoTao);

        return nhomKienThucRepository.save(nhomKienThuc);
    }


    public List<KhoiKienThuc> getAllNhomKienThuc() {
        return nhomKienThucRepository.findAll();
    }


    public KhoiKienThuc getNhomKienThucById(String id) {
        return nhomKienThucRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhóm kiến thức với ID: " + id));
    }


    public KhoiKienThuc updateNhomKienThuc(String id, KhoiKienThuc nhomKienThucDetails) {
        KhoiKienThuc nhomKienThuc = nhomKienThucRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhóm kiến thức với ID: " + id));


        Optional<KhoiKienThuc> existingNhomKienThuc = nhomKienThucRepository.findByTen(nhomKienThucDetails.getTen());
        if (existingNhomKienThuc.isPresent() && !existingNhomKienThuc.get().getId().equals(id)) {
            throw new IllegalArgumentException("Nhóm kiến thức với tên " + nhomKienThucDetails.getTen() + " đã tồn tại!");
        }

        nhomKienThuc.setTen(nhomKienThucDetails.getTen());
        nhomKienThuc.setTinChiBatBuoc(nhomKienThucDetails.getTinChiBatBuoc());
        nhomKienThuc.setTinChiTuChon(nhomKienThucDetails.getTinChiTuChon());


        if (nhomKienThucDetails.getChuongTrinhDaoTao() != null) {
            ChuongTrinhDaoTao chuongTrinhDaoTao = chuongTrinhDaoTaoRepository.findById(nhomKienThucDetails.getChuongTrinhDaoTao().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy chương trình đào tạo với ID: " + nhomKienThucDetails.getChuongTrinhDaoTao().getId()));
            nhomKienThuc.setChuongTrinhDaoTao(chuongTrinhDaoTao);
        }

        return nhomKienThucRepository.save(nhomKienThuc);
    }


    public void deleteNhomKienThuc(String id) {
        KhoiKienThuc nhomKienThuc = nhomKienThucRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhóm kiến thức với ID: " + id));
        nhomKienThucRepository.delete(nhomKienThuc);
    }
}