package com.example.project0002.service;

import com.example.project0002.model.KeHoachDayHoc;
import com.example.project0002.model.HocPhan;
import com.example.project0002.model.KeHoachDayHoc_NganhHoc;
import com.example.project0002.model.NganhHoc;
import com.example.project0002.repository.KeHoachDayHocRepository;
import com.example.project0002.repository.HocPhanRepository;
import com.example.project0002.repository.NganhHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KeHoachDayHocService {

    @Autowired
    private KeHoachDayHocRepository keHoachDayHocRepository;

    @Autowired
    private NganhHocRepository nganhHocRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @Autowired
    private KeHoachDayHocNganhHocService keHoachDayHocNganhHocService;

    public List<KeHoachDayHoc> findByHocKyAndNganhHocId(Integer hocKy, String nganhHocId) {
        return keHoachDayHocRepository.findByHocKyAndNganhHocId(hocKy, nganhHocId);
    }

    // Create
    public KeHoachDayHoc createKeHoachDayHoc(KeHoachDayHoc keHoachDayHoc) {

        HocPhan hocPhan = hocPhanRepository.findById(keHoachDayHoc.getHocPhan().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + keHoachDayHoc.getHocPhan().getId()));
        keHoachDayHoc.setHocPhan(hocPhan);

        KeHoachDayHoc savedKeHoach = keHoachDayHocRepository.save(keHoachDayHoc);

        if (keHoachDayHoc.getNganhHocId() != null) {
            NganhHoc nganhHoc = nganhHocRepository.findById(keHoachDayHoc.getNganhHocId())
                    .orElseThrow(() -> new RuntimeException("NganhHoc not found"));

            KeHoachDayHoc_NganhHoc keHoachNganhHoc = new KeHoachDayHoc_NganhHoc(
                    UUID.randomUUID().toString(),
                    savedKeHoach,
                    nganhHoc
            );
            keHoachDayHocNganhHocService.createKeHoachDayHocNganhHoc(keHoachNganhHoc);
        }

        return savedKeHoach;
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

//        if(keHoachDayHocDetails.getHocPhanTruoc() != null) {
//            HocPhan hocPhan = hocPhanRepository.findById(keHoachDayHocDetails.getHocPhanTruoc().getId())
//                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy học phần với ID: " + keHoachDayHocDetails.getHocPhanTruoc().getId()));
//            keHoachDayHoc.setHocPhanTruoc(hocPhan);
//        }

        return keHoachDayHocRepository.save(keHoachDayHoc);
    }

    // Delete
    public void deleteKeHoachDayHoc(String id) {
        KeHoachDayHoc keHoachDayHoc = keHoachDayHocRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy kế hoạch dạy học với ID: " + id));
        keHoachDayHocRepository.delete(keHoachDayHoc);
    }
}