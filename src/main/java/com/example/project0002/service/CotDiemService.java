package com.example.project0002.service;

import com.example.project0002.model.CotDiem;
import com.example.project0002.model.DeCuongChiTiet;
import com.example.project0002.repository.CotDiemRepository;
import com.example.project0002.repository.DeCuongChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CotDiemService {

    @Autowired
    private CotDiemRepository cotDiemRepository;

    @Autowired
    private DeCuongChiTietRepository deCuongChiTietRepository;


    public CotDiem createCotDiem(CotDiem cotDiem) {
        Optional<CotDiem> existingCotDiem = cotDiemRepository.findByTenCotDiem(cotDiem.getTenCotDiem());
        if (existingCotDiem.isPresent()) {
            throw new IllegalArgumentException("Cột điểm với tên " + cotDiem.getTenCotDiem() + " đã tồn tại!");
        }


        DeCuongChiTiet deCuongChiTiet = deCuongChiTietRepository.findById(cotDiem.getDeCuongChiTiet().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đề cương chi tiết với ID: " + cotDiem.getDeCuongChiTiet().getId()));
        cotDiem.setDeCuongChiTiet(deCuongChiTiet);

        return cotDiemRepository.save(cotDiem);
    }


    public List<CotDiem> getAllCotDiem() {
        return cotDiemRepository.findAll();
    }


    public CotDiem getCotDiemById(String id) {
        return cotDiemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cột điểm với ID: " + id));
    }


    public CotDiem updateCotDiem(String id, CotDiem cotDiemDetails) {
        CotDiem cotDiem = cotDiemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cột điểm với ID: " + id));


        Optional<CotDiem> existingCotDiem = cotDiemRepository.findByTenCotDiem(cotDiemDetails.getTenCotDiem());
        if (existingCotDiem.isPresent() && !existingCotDiem.get().getId().equals(id)) {
            throw new IllegalArgumentException("Cột điểm với tên " + cotDiemDetails.getTenCotDiem() + " đã tồn tại!");
        }

        cotDiem.setTenCotDiem(cotDiemDetails.getTenCotDiem());
        cotDiem.setDeCuongChiTiet(cotDiemDetails.getDeCuongChiTiet());
        cotDiem.setHinhThucDanhGia(cotDiemDetails.getHinhThucDanhGia());
        cotDiem.setTrongSoDanhGia(cotDiemDetails.getTrongSoDanhGia());


        if (cotDiemDetails.getDeCuongChiTiet() != null) {
            DeCuongChiTiet deCuongChiTiet = deCuongChiTietRepository.findById(cotDiemDetails.getDeCuongChiTiet().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy đề cương chi tiết với ID: " + cotDiemDetails.getDeCuongChiTiet().getId()));
            cotDiem.setDeCuongChiTiet(deCuongChiTiet);
        }

        return cotDiemRepository.save(cotDiem);
    }


    public void deleteCotDiem(String id) {
        CotDiem cotDiem = cotDiemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy cột điểm với ID: " + id));
        cotDiemRepository.delete(cotDiem);
    }
}