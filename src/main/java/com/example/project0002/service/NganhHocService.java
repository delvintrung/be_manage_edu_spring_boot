package com.example.project0002.service;

import com.example.project0002.dto.NganhHocDto;
import com.example.project0002.model.NganhHoc;
import com.example.project0002.model.Khoa;
import com.example.project0002.repository.HocPhanRepository;
import com.example.project0002.repository.NganhHocRepository;
import com.example.project0002.repository.KhoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NganhHocService {

    @Autowired
    private NganhHocRepository nganhHocRepository;

    @Autowired
    private KhoaRepository khoaRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    // Create
    public NganhHoc createNganhHoc(NganhHoc nganhHoc) {
        Optional<NganhHoc> existingNganhHoc = nganhHocRepository.findByTen(nganhHoc.getTen());
        if (existingNganhHoc.isPresent()) {
            throw new IllegalArgumentException("Ngành học với tên " + nganhHoc.getTen() + " đã tồn tại!");
        }

        // Kiểm tra khoa tồn tại
        Khoa khoa = khoaRepository.findById(nganhHoc.getKhoa().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khoa với ID: " + nganhHoc.getKhoa().getId()));
        nganhHoc.setKhoa(khoa);

        return nganhHocRepository.save(nganhHoc);
    }

    // Read (all)
    public List<NganhHocDto> getAllNganhHoc() {
        List<NganhHoc> nganhHocs = nganhHocRepository.findAll();

        List<NganhHocDto> list = new java.util.ArrayList<>(List.of());

        nganhHocs.forEach(nganhHoc -> {
            Integer tongSoHocPhan = hocPhanRepository.countHocPhanByNganhHoc_Id(nganhHoc.getId());
            Integer tongSoTinChi = hocPhanRepository.sumTinChiByNganhHocId(nganhHoc.getId());

            if (tongSoHocPhan == null) {
                tongSoHocPhan = 0;
            }
            if (tongSoTinChi == null) {
                tongSoTinChi = 0;
            }

            NganhHocDto nganhHocDto = new NganhHocDto();
            nganhHocDto.setId(nganhHoc.getId());
            nganhHocDto.setKhoa(nganhHoc.getKhoa());
            nganhHocDto.setMoTa(nganhHoc.getMoTa());
            nganhHocDto.setTen(nganhHoc.getTen());
            nganhHocDto.setTongSoTinChi(tongSoTinChi);
            nganhHocDto.setTongSoHocPhan(tongSoHocPhan);

            list.add(nganhHocDto);
        });

        return list;
    }

    // Read (by ID)
    public NganhHoc getNganhHocById(String id) {
        return nganhHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ngành học với ID: " + id));
    }

    // Update
    public NganhHoc updateNganhHoc(String id, NganhHoc nganhHocDetails) {
        NganhHoc nganhHoc = nganhHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ngành học với ID: " + id));

        // Kiểm tra trùng lặp tên ngành học (trừ chính ngành học đang cập nhật)
        Optional<NganhHoc> existingNganhHoc = nganhHocRepository.findByTen(nganhHocDetails.getTen());
        if (existingNganhHoc.isPresent() && !existingNganhHoc.get().getId().equals(id)) {
            throw new IllegalArgumentException("Ngành học với tên " + nganhHocDetails.getTen() + " đã tồn tại!");
        }

        // Cập nhật thông tin
        nganhHoc.setTen(nganhHocDetails.getTen());
        nganhHoc.setMoTa(nganhHocDetails.getMoTa());

        // Cập nhật khoa nếu có
        if (nganhHocDetails.getKhoa() != null) {
            Khoa khoa = khoaRepository.findById(nganhHocDetails.getKhoa().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khoa với ID: " + nganhHocDetails.getKhoa().getId()));
            nganhHoc.setKhoa(khoa);
        }

        return nganhHocRepository.save(nganhHoc);
    }

    // Delete
    public void deleteNganhHoc(String id) {
        NganhHoc nganhHoc = nganhHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy ngành học với ID: " + id));
        nganhHocRepository.delete(nganhHoc);
    }
}