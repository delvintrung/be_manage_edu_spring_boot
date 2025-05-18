package com.example.project0002.service;

import com.example.project0002.model.DeCuongChiTiet;
import com.example.project0002.model.HocPhan;
import com.example.project0002.repository.DeCuongChiTietRepository;
import com.example.project0002.repository.HocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeCuongChiTietService {

    @Autowired
    private DeCuongChiTietRepository deCuongChiTietRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    // Create
    public DeCuongChiTiet createDeCuongChiTiet(DeCuongChiTiet deCuongChiTiet) {
        // Kiểm tra học phần tồn tại
        HocPhan hocPhan = hocPhanRepository.findById(deCuongChiTiet.getHocPhan().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + deCuongChiTiet.getHocPhan().getId()));
        deCuongChiTiet.setHocPhan(hocPhan);

        return deCuongChiTietRepository.save(deCuongChiTiet);
    }

    // Read (all)
    public List<DeCuongChiTiet> getAllDeCuongChiTiet() {
        return deCuongChiTietRepository.findAll();
    }

    // Read (by ID)
    public DeCuongChiTiet getDeCuongChiTietById(String id) {
        return deCuongChiTietRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đề cương chi tiết với ID: " + id));
    }

    // Update
    public DeCuongChiTiet updateDeCuongChiTiet(String id, DeCuongChiTiet deCuongChiTietDetails) {
        DeCuongChiTiet deCuongChiTiet = deCuongChiTietRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đề cương chi tiết với ID: " + id));

        deCuongChiTiet.setHocPhan(deCuongChiTietDetails.getHocPhan());

        // Cập nhật học phần nếu có
        if (deCuongChiTietDetails.getHocPhan() != null) {
            HocPhan hocPhan = hocPhanRepository.findById(deCuongChiTietDetails.getHocPhan().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + deCuongChiTietDetails.getHocPhan().getId()));
            deCuongChiTiet.setHocPhan(hocPhan);
        }

        return deCuongChiTietRepository.save(deCuongChiTiet);
    }

    // Delete
    public void deleteDeCuongChiTiet(String id) {
        DeCuongChiTiet deCuongChiTiet = deCuongChiTietRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đề cương chi tiết với ID: " + id));
        deCuongChiTietRepository.delete(deCuongChiTiet);
    }
}