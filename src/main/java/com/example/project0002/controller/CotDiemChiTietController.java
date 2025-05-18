package com.example.project0002.controller;

import com.example.project0002.model.CotDiemChiTiet;
import com.example.project0002.service.CotDiemChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cotdiemchitiet")
public class CotDiemChiTietController {

    @Autowired
    private CotDiemChiTietService cotDiemChiTietService;

    @GetMapping("/deCuong/{deCuongId}")
    public ResponseEntity<List<CotDiemChiTiet>> getCotDiemChiTietByDeCuongId(@PathVariable String deCuongId) {
        List<CotDiemChiTiet> cotDiemChiTiets = cotDiemChiTietService.findByDeCuongChiTietId(deCuongId);
        return ResponseEntity.ok(cotDiemChiTiets);
    }
}