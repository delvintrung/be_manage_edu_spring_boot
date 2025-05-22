package com.example.project0002.service;

import com.example.project0002.model.KhoiKienThuc_KhungChuongTrinh;
import com.example.project0002.repository.KhoiKienThucKhungChuongTrinhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoiKienThucKhungChuongTrinhService {
    @Autowired
    private KhoiKienThucKhungChuongTrinhRepository khoiKienThucKhungChuongTrinhRepository;

    public List<KhoiKienThuc_KhungChuongTrinh> getAllKhoiKienThucKhungChuongTrinh() {
        return khoiKienThucKhungChuongTrinhRepository.findAll();
    }

    public KhoiKienThuc_KhungChuongTrinh findKhoiKienThucKhungChuongTrinhById(String id) {
        return khoiKienThucKhungChuongTrinhRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khung chương trình với ID: " + id));
    }
}
