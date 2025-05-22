package com.example.project0002.controller;

import com.example.project0002.model.ChuongTrinhKhung;
import com.example.project0002.repository.KhoiKienThucKhungChuongTrinhRepository;
import com.example.project0002.repository.KhungChuongTrinhRepository;
import com.example.project0002.repository.NganhHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class KhungChuongTrinhController {

    @Autowired
    private KhungChuongTrinhRepository chuongTrinhKhungRepository;

    @Autowired
    private NganhHocRepository nganhHocRepository;

    @Autowired
    private KhoiKienThucKhungChuongTrinhRepository khoiKienThucKhungChuongTrinhRepository;


    @GetMapping("/chuongtrinhkhung")
    public ResponseEntity<List<ChuongTrinhKhung>> getAllChuongTrinhKhungs() {
        List<ChuongTrinhKhung> chuongTrinhKhungs = chuongTrinhKhungRepository.findAll();
        return ResponseEntity.ok(chuongTrinhKhungs);
    }


    @GetMapping("/chuongtrinhkhung/{id}")
    public ResponseEntity<ChuongTrinhKhung> getChuongTrinhKhungById(@PathVariable String id) {
        Optional<ChuongTrinhKhung> chuongTrinhKhung = chuongTrinhKhungRepository.findById(id);
        if (chuongTrinhKhung.isPresent()) {
            return ResponseEntity.ok(chuongTrinhKhung.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}