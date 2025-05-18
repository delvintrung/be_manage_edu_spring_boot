package com.example.project0002.service;

import com.example.project0002.model.GiangVien;
import com.example.project0002.model.Khoa;
import com.example.project0002.model.User;
import com.example.project0002.repository.GiangVienRepository;
import com.example.project0002.repository.KhoaRepository;
import com.example.project0002.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GiangVienService {

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private KhoaRepository khoaRepository;

    @Autowired
    private UserRepository userRepository;

    public  long countAllGiangVien() {
        long count = giangVienRepository.count();
        return  count;
    }

    // Create
    public GiangVien createGiangVien(GiangVien giangVien) {
        Optional<GiangVien> existingGiangVien = giangVienRepository.findByHoTen(giangVien.getHoTen());
        if (existingGiangVien.isPresent()) {
            throw new IllegalArgumentException("Giảng viên với họ tên " + giangVien.getHoTen() + " đã tồn tại!");
        }

        // Kiểm tra khoa tồn tại
        Khoa khoa = khoaRepository.findById(giangVien.getKhoa().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khoa với ID: " + giangVien.getKhoa().getId()));
        giangVien.setKhoa(khoa);

        // Kiểm tra user tồn tại
        User user = userRepository.findById(giangVien.getUser().getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy user với ID: " + giangVien.getUser().getId()));
        giangVien.setUser(user);

        userRepository.updateRole(giangVien.getId(), "GIANGVIEN");
        return giangVienRepository.save(giangVien);
    }

    // Read (all)
    public List<GiangVien> getAllGiangVien() {
        return giangVienRepository.findAll();
    }

    // Read (by ID)
    public GiangVien getGiangVienById(String id) {
        return giangVienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy giảng viên với ID: " + id));
    }

    // Update
    public GiangVien updateGiangVien(String id, GiangVien giangVienDetails) {
        GiangVien giangVien = giangVienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy giảng viên với ID: " + id));

        // Kiểm tra trùng lặp họ tên (trừ chính giảng viên đang cập nhật)
        Optional<GiangVien> existingGiangVien = giangVienRepository.findByHoTen(giangVienDetails.getHoTen());
        if (existingGiangVien.isPresent() && !existingGiangVien.get().getId().equals(id)) {
            throw new IllegalArgumentException("Giảng viên với họ tên " + giangVienDetails.getHoTen() + " đã tồn tại!");
        }

        giangVien.setHoTen(giangVienDetails.getHoTen());
        giangVien.setTrinhDo(giangVienDetails.getTrinhDo());
        giangVien.setChuyenMon(giangVienDetails.getChuyenMon());
        giangVien.setNamSinh(giangVienDetails.getNamSinh());

        // Cập nhật khoa nếu có
        if (giangVienDetails.getKhoa() != null) {
            Khoa khoa = khoaRepository.findById(giangVienDetails.getKhoa().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khoa với ID: " + giangVienDetails.getKhoa().getId()));
            giangVien.setKhoa(khoa);
        }

        // Cập nhật user nếu có
        if (giangVienDetails.getUser() != null) {
            User user = userRepository.findById(giangVienDetails.getUser().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy user với ID: " + giangVienDetails.getUser().getId()));
            giangVien.setUser(user);
        }

        return giangVienRepository.save(giangVien);
    }

    // Delete
    public void deleteGiangVien(String id) {
        GiangVien giangVien = giangVienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy giảng viên với ID: " + id));
        giangVienRepository.delete(giangVien);
    }
}