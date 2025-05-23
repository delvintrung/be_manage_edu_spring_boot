package com.example.project0002.service;

import com.example.project0002.model.HocPhan;
import com.example.project0002.model.NganhHoc;
import com.example.project0002.repository.HocPhanRepository;
import com.example.project0002.repository.NganhHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HocPhanService {

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Autowired
    private NganhHocRepository nganhHocRepository;

    // Create
    public HocPhan createHocPhan(HocPhan hocPhan) {
        Optional<HocPhan> existingHocPhan = hocPhanRepository.findByTen(hocPhan.getTen());
        if (existingHocPhan.isPresent()) {
            throw new IllegalArgumentException("Học phần với tên " + hocPhan.getTen() + " đã tồn tại!");
        }

        return hocPhanRepository.save(hocPhan);
    }

    // Read (all)
    public List<HocPhan> getAllHocPhan() {
        return hocPhanRepository.findAll();
    }

    public List<HocPhan> getFilterHocPhan(String nganhHocId) {
        return hocPhanRepository.findAllByNganhHoc_Id(nganhHocId);
    }

    // Read (by ID)
    public HocPhan getHocPhanById(String id) {
        return hocPhanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + id));
    }

    // Update
    public HocPhan updateHocPhan(String id, HocPhan hocPhanDetails) {
        HocPhan hocPhan = hocPhanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + id));

        // Kiểm tra trùng lặp tên học phần (trừ chính học phần đang cập nhật)
        Optional<HocPhan> existingHocPhan = hocPhanRepository.findByTen(hocPhanDetails.getTen());
        if (existingHocPhan.isPresent() && !existingHocPhan.get().getId().equals(id)) {
            throw new IllegalArgumentException("Học phần với tên " + hocPhanDetails.getTen() + " đã tồn tại!");
        }

        hocPhan.setTen(hocPhanDetails.getTen());
        hocPhan.setTinChi(hocPhanDetails.getTinChi());
        hocPhan.setTietLyThuyet(hocPhanDetails.getTietLyThuyet());
        hocPhan.setTietThucHanh(hocPhanDetails.getTietThucHanh());



        return hocPhanRepository.save(hocPhan);
    }

    // Delete
    public void deleteHocPhan(String id) {
        HocPhan hocPhan = hocPhanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + id));
        hocPhanRepository.delete(hocPhan);
    }
}