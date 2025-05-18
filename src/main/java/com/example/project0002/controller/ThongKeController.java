package com.example.project0002.controller;

import com.example.project0002.model.HocPhan;
import com.example.project0002.model.Khoa;
import com.example.project0002.repository.HocPhanRepository;
import com.example.project0002.service.GiangVienService;
import com.example.project0002.repository.KhoaRepository;
import com.example.project0002.repository.GiangVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/thongke")
public class ThongKeController {

    @Autowired
    private GiangVienService giangVienService;

    @Autowired
    private GiangVienRepository giangVienRepository;

    @Autowired
    private KhoaRepository khoaRepository;

    @Autowired
    private HocPhanRepository hocPhanRepository;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getThongKe() {
        long tongGiangVien = giangVienRepository.findAll().size();

        List<Khoa> khoaList = khoaRepository.findAll();

        List<HocPhan> hocPhanList = hocPhanRepository.findAll();

        Map<String, Object> thongKe = new HashMap<>();
        thongKe.put("soGiangVien", tongGiangVien);
        thongKe.put("soKhoa", khoaList.size());
        thongKe.put("soHocPhan", hocPhanList.size());
        return ResponseEntity.ok(thongKe);
    }
}