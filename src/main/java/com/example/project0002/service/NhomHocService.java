package com.example.project0002.service;

import com.example.project0002.model.KeHoachMoNhom;
import com.example.project0002.model.NhomHoc;
import com.example.project0002.model.PhanCongGiangDay;
import com.example.project0002.model.GiangVien;
import com.example.project0002.repository.KeHoachMoNhomRepository;
import com.example.project0002.repository.NhomHocRepository;
import com.example.project0002.repository.PhanCongGiangDayRepository;
import com.example.project0002.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NhomHocService {

    @Autowired
    private NhomHocRepository nhomHocRepository;

    @Autowired
    private KeHoachMoNhomRepository keHoachMoNhomRepository;

    @Autowired
    private PhanCongGiangDayRepository phanCongGiangDayRepository;

    @Autowired
    private GiangVienRepository giangVienRepository;

    public List<NhomHoc> createNhomHoc(String keHoachMoNhomId) {
        Optional<KeHoachMoNhom> keHoachMoNhomOpt = keHoachMoNhomRepository.findById(keHoachMoNhomId);
        if (keHoachMoNhomOpt.isEmpty()) {
            return List.of();
        }

        KeHoachMoNhom keHoachMoNhom = keHoachMoNhomOpt.get();
        int soSinhVien = keHoachMoNhom.getSoSinhVien();
        int soSinhVienMotLop = keHoachMoNhom.getSoSinhVienMotLop();
        int soNhom = (int) Math.ceil((double) soSinhVien / soSinhVienMotLop);

        // Xóa nhóm cũ nếu có
        nhomHocRepository.deleteAll(nhomHocRepository.findByKeHoachMoNhomId(keHoachMoNhomId));

        // Tạo nhóm mới (chưa phân công giảng viên)
        List<NhomHoc> nhomHocs = new ArrayList<>();
        for (int i = 1; i <= soNhom; i++) {
            int soSinhVienNhom = Math.min(soSinhVienMotLop, soSinhVien - (i - 1) * soSinhVienMotLop);
            NhomHoc nhomHoc = new NhomHoc(
                    UUID.randomUUID().toString(),
                    keHoachMoNhom,
                    null, // Chưa phân công giảng viên
                    i,
                    soSinhVienNhom
            );
            nhomHocs.add(nhomHocRepository.save(nhomHoc));
        }
        return nhomHocs;
    }

    public List<NhomHoc> assignLecturersManually(String keHoachMoNhomId, Map<String, Integer> lecturerAssignments) {
        List<NhomHoc> nhomHocs = nhomHocRepository.findByKeHoachMoNhomId(keHoachMoNhomId);
        if (nhomHocs.isEmpty()) {
            return List.of();
        }

        int totalAssignedGroups = lecturerAssignments.values().stream().mapToInt(Integer::intValue).sum();
        if (totalAssignedGroups > nhomHocs.size()) {
            throw new IllegalArgumentException("Số nhóm phân công vượt quá số nhóm hiện có");
        }

        // Lấy danh sách giảng viên
        List<GiangVien> lecturers = new ArrayList<>();
        for (String lecturerId : lecturerAssignments.keySet()) {
            Optional<GiangVien> lecturerOpt = giangVienRepository.findById(lecturerId);
            if (lecturerOpt.isPresent()) {
                lecturers.add(lecturerOpt.get());
            }
        }

        // Phân công giảng viên cho từng nhóm
        int groupIndex = 0;
        for (Map.Entry<String, Integer> entry : lecturerAssignments.entrySet()) {
            String lecturerId = entry.getKey();
            int numGroups = entry.getValue();
            Optional<GiangVien> lecturerOpt = giangVienRepository.findById(lecturerId);
            if (lecturerOpt.isEmpty()) continue;

            GiangVien lecturer = lecturerOpt.get();
            for (int i = 0; i < numGroups && groupIndex < nhomHocs.size(); i++) {
                NhomHoc nhomHoc = nhomHocs.get(groupIndex++);
                nhomHoc.setGiangVien(lecturer);
                nhomHocRepository.save(nhomHoc);
            }
        }

        return nhomHocRepository.findByKeHoachMoNhomId(keHoachMoNhomId);
    }

    public List<NhomHoc> assignLecturersAutomatically(String keHoachMoNhomId) {
        List<NhomHoc> nhomHocs = nhomHocRepository.findByKeHoachMoNhomId(keHoachMoNhomId);
        if (nhomHocs.isEmpty()) {
            return List.of();
        }

        // Lấy tất cả giảng viên đã được phân công cho kế hoạch này (dựa trên PhanCongGiangDay)
        List<PhanCongGiangDay> phanCongList = phanCongGiangDayRepository.findAll().stream()
                .filter(pc -> pc.getKeHoachMoNhom().getId().equals(keHoachMoNhomId))
                .toList();
        List<GiangVien> availableLecturers = phanCongList.stream()
                .map(PhanCongGiangDay::getGiangVien)
                .collect(Collectors.toList());

        if (availableLecturers.isEmpty()) {
            throw new IllegalStateException("Không có giảng viên nào để phân công tự động");
        }

        // Kiểm tra tổng số nhóm đã được phân công
//        int totalGroupsAssigned = nhomHocs.stream().filter(nh -> nhomHocs.stream().filter(nh -> nhomHocs.getGiangVien() != null).mapToInt(nh -> 1).sum();
//        if (totalGroupsAssigned != nhomHocs.size()) {
//            throw new IllegalStateException("Số nhóm chưa được phân công đầy đủ để thực hiện phân công tự động");
//        }

        // Phân công ngẫu nhiên
        Collections.shuffle(nhomHocs);
        Collections.shuffle(availableLecturers);
        for (int i = 0; i < nhomHocs.size(); i++) {
            NhomHoc nhomHoc = nhomHocs.get(i);
            GiangVien lecturer = availableLecturers.get(i % availableLecturers.size());
            nhomHoc.setGiangVien(lecturer);
            nhomHocRepository.save(nhomHoc);
        }

        return nhomHocRepository.findByKeHoachMoNhomId(keHoachMoNhomId);
    }

    public List<NhomHoc> getAllNhomHoc() {
        return nhomHocRepository.findAll();
    }

    public List<NhomHoc> getNhomHocByNganhHoc(String nganhHocId) {
        return nhomHocRepository.findByKeHoachMoNhomHocPhanNganhHocId(nganhHocId);
    }

    public List<NhomHoc> getNhomHocByGiangVien(String giangVienId) {
        return nhomHocRepository.findByGiangVienId(giangVienId);
    }

    public void deleteNhomHoc(String id) {
        nhomHocRepository.deleteById(id);
    }
}