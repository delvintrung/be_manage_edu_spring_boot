package com.example.project0002.service;

import com.example.project0002.model.KeHoachDayHoc;
import com.example.project0002.model.HocPhan;
import com.example.project0002.repository.KeHoachDayHocRepository;
import com.example.project0002.repository.HocPhanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeHoachDayHocService {

    @Autowired
    private KeHoachDayHocRepository keHoachDayHocRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    // Create
    public KeHoachDayHoc createKeHoachDayHoc(KeHoachDayHoc keHoachDayHoc) {
        // Kiểm tra học phần tồn tại
        HocPhan hocPhan = hocPhanRepository.findById(keHoachDayHoc.getHocPhan().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + keHoachDayHoc.getHocPhan().getId()));
        keHoachDayHoc.setHocPhan(hocPhan);

        return keHoachDayHocRepository.save(keHoachDayHoc);
    }

    // Read (all)
    public List<KeHoachDayHoc> getAllKeHoachDayHoc() {
        return keHoachDayHocRepository.findAll();
    }

    // Read (by ID)
    public KeHoachDayHoc getKeHoachDayHocById(String id) {
        return keHoachDayHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kế hoạch dạy học với ID: " + id));
    }

    // Update
    public KeHoachDayHoc updateKeHoachDayHoc(String id, KeHoachDayHoc keHoachDayHocDetails) {
        KeHoachDayHoc keHoachDayHoc = keHoachDayHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kế hoạch dạy học với ID: " + id));

        keHoachDayHoc.setHocKy(keHoachDayHocDetails.getHocKy());

        // Cập nhật học phần nếu có
        if (keHoachDayHocDetails.getHocPhan() != null) {
            HocPhan hocPhan = hocPhanRepository.findById(keHoachDayHocDetails.getHocPhan().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + keHoachDayHocDetails.getHocPhan().getId()));
            keHoachDayHoc.setHocPhan(hocPhan);
        }

        return keHoachDayHocRepository.save(keHoachDayHoc);
    }

    // Delete
    public void deleteKeHoachDayHoc(String id) {
        KeHoachDayHoc keHoachDayHoc = keHoachDayHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kế hoạch dạy học với ID: " + id));
        keHoachDayHocRepository.delete(keHoachDayHoc);
    }
}