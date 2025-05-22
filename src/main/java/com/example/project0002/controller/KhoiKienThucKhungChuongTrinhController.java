package com.example.project0002.controller;

import com.example.project0002.model.KhoiKienThuc_KhungChuongTrinh;
import com.example.project0002.service.KhoiKienThucKhungChuongTrinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/khoikienthuckhungchuongtrinh")
public class KhoiKienThucKhungChuongTrinhController {

    @Autowired
    private KhoiKienThucKhungChuongTrinhService khoiKienThucKhungChuongTrinhService;

    @GetMapping
    public ResponseEntity<List<KhoiKienThuc_KhungChuongTrinh>> getAllKhoa() {
        List<KhoiKienThuc_KhungChuongTrinh> khoaList = khoiKienThucKhungChuongTrinhService.getAllKhoiKienThucKhungChuongTrinh();
        return ResponseEntity.ok(khoaList);
    }
}
