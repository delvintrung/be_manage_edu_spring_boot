package com.example.project0002.service;

import com.example.project0002.model.GiangVien;
import com.example.project0002.model.KeHoachMoNhom;
import com.example.project0002.model.NhomHoc;
import com.example.project0002.model.PhanCongGiangDay;
import com.example.project0002.repository.GiangVienRepository;
import com.example.project0002.repository.KeHoachMoNhomRepository;
import com.example.project0002.repository.NhomHocRepository;
import com.example.project0002.repository.PhanCongGiangDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhanCongGiangDayService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private KeHoachMoNhomRepository keHoachMoNhomRepository;

    @Autowired
    private NhomHocRepository nhomHocRepository;

    @Autowired
    private PhanCongGiangDayRepository phanCongGiangDayRepository;

    public PhanCongGiangDay createPhanCongGiangDay(PhanCongGiangDay phanCongGiangDay) {
        // Validate KeHoachMoNhom
        Optional<KeHoachMoNhom> keHoachMoNhomOpt = keHoachMoNhomRepository.findById(phanCongGiangDay.getKeHoachMoNhom().getId());
        if (keHoachMoNhomOpt.isEmpty()) {
            throw new IllegalArgumentException("Kế hoạch mở nhóm không tồn tại");
        }

        // Validate GiangVien
        Optional<GiangVien> giangVienOpt = giangVienRepository.findById(phanCongGiangDay.getGiangVien().getId());
        if (giangVienOpt.isEmpty()) {
            throw new IllegalArgumentException("Giảng viên không tồn tại");
        }

        KeHoachMoNhom keHoachMoNhom = keHoachMoNhomOpt.get();
        GiangVien giangVien = giangVienOpt.get();



        // Validate NhomHoc
        Optional<NhomHoc> nhomHocOpt = nhomHocRepository.findByKeHoachMoNhomIdAndMaNhom(
                keHoachMoNhom.getId(), phanCongGiangDay.getNhom());
        if (nhomHocOpt.isEmpty()) {
            throw new IllegalArgumentException("Nhóm học không tồn tại cho kế hoạch mở nhóm này");
        }

        NhomHoc nhomHoc = nhomHocOpt.get();
        if (nhomHoc.getGiangVien() != null) {
            throw new IllegalArgumentException("Nhóm học đã được phân công cho giảng viên khác");
        }

        // Set soTiet from input (UI provides it)
        if (phanCongGiangDay.getSoTiet() <= 0) {
            throw new IllegalArgumentException("Số tiết phải lớn hơn 0");
        }

        // Save and update NhomHoc
        PhanCongGiangDay savedPhanCong = phanCongGiangDayRepository.save(phanCongGiangDay);
        nhomHoc.setGiangVien(giangVien);
        nhomHocRepository.save(nhomHoc);

        return savedPhanCong;
    }

    public List<PhanCongGiangDay> getAllPhanCongGiangDay() {
        return phanCongGiangDayRepository.findAll();
    }

    public List<PhanCongGiangDay> getPhanCongGiangDayByKeHoachMoNhomId(String keHoachMoNhomId) {
        return phanCongGiangDayRepository.findByKeHoachMoNhomId(keHoachMoNhomId);
    }

    public PhanCongGiangDay getPhanCongGiangDayById(String id) {
        return phanCongGiangDayRepository.findById(id).orElse(null);
    }

    public PhanCongGiangDay updatePhanCongGiangDay(String id, PhanCongGiangDay phanCongGiangDayDetails) {
        Optional<PhanCongGiangDay> existingOpt = phanCongGiangDayRepository.findById(id);
        if (existingOpt.isEmpty()) {
            return null;
        }

        PhanCongGiangDay existing = existingOpt.get();

        // Validate KeHoachMoNhom
        Optional<KeHoachMoNhom> keHoachMoNhomOpt = keHoachMoNhomRepository.findById(phanCongGiangDayDetails.getKeHoachMoNhom().getId());
        if (keHoachMoNhomOpt.isEmpty()) {
            throw new IllegalArgumentException("Kế hoạch mở nhóm không tồn tại");
        }

        // Validate GiangVien
        Optional<GiangVien> giangVienOpt = giangVienRepository.findById(phanCongGiangDayDetails.getGiangVien().getId());
        if (giangVienOpt.isEmpty()) {
            throw new IllegalArgumentException("Giảng viên không tồn tại");
        }

        KeHoachMoNhom keHoachMoNhom = keHoachMoNhomOpt.get();
        GiangVien giangVien = giangVienOpt.get();

        // Validate NhomHoc
        Optional<NhomHoc> nhomHocOpt = nhomHocRepository.findByKeHoachMoNhomIdAndMaNhom(
                keHoachMoNhom.getId(), phanCongGiangDayDetails.getNhom());
        if (nhomHocOpt.isEmpty()) {
            throw new IllegalArgumentException("Nhóm học không tồn tại cho kế hoạch mở nhóm này");
        }

        NhomHoc nhomHoc = nhomHocOpt.get();
        if (nhomHoc.getGiangVien() != null && !nhomHoc.getGiangVien().getId().equals(giangVien.getId())) {
            throw new IllegalArgumentException("Nhóm học đã được phân công cho giảng viên khác");
        }

        // Update fields
        existing.setGiangVien(phanCongGiangDayDetails.getGiangVien());
        existing.setKeHoachMoNhom(phanCongGiangDayDetails.getKeHoachMoNhom());
        existing.setNhom(phanCongGiangDayDetails.getNhom());
        existing.setHocKy(phanCongGiangDayDetails.getHocKy());
        existing.setSoTiet(phanCongGiangDayDetails.getSoTiet());

        // Validate soTiet
        if (existing.getSoTiet() <= 0) {
            throw new IllegalArgumentException("Số tiết phải lớn hơn 0");
        }

        // Update NhomHoc
        nhomHoc.setGiangVien(giangVien);
        nhomHocRepository.save(nhomHoc);

        return phanCongGiangDayRepository.save(existing);
    }

    public void deletePhanCongGiangDay(String id) {
        Optional<PhanCongGiangDay> phanCongOpt = phanCongGiangDayRepository.findById(id);
        if (phanCongOpt.isEmpty()) {
            throw new IllegalArgumentException("Phân công giảng dạy không tồn tại");
        }

        PhanCongGiangDay phanCong = phanCongOpt.get();
        Optional<NhomHoc> nhomHocOpt = nhomHocRepository.findByKeHoachMoNhomIdAndMaNhom(
                phanCong.getKeHoachMoNhom().getId(), phanCong.getNhom());
        if (nhomHocOpt.isPresent()) {
            NhomHoc nhomHoc = nhomHocOpt.get();
            nhomHoc.setGiangVien(null);
            nhomHocRepository.save(nhomHoc);
        }

        phanCongGiangDayRepository.deleteById(id);
    }
}