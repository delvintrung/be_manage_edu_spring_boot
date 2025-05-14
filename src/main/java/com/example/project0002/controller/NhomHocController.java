package com.example.project0002.controller;

import com.example.project0002.model.NhomHoc;
import com.example.project0002.service.NhomHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nhomhoc")
public class NhomHocController {

    @Autowired
    private NhomHocService nhomHocService;

    @PostMapping("/create/{keHoachMoNhomId}")
    public ResponseEntity<List<NhomHoc>> createNhomHoc(@PathVariable String keHoachMoNhomId) {
        List<NhomHoc> nhomHocs = nhomHocService.createNhomHoc(keHoachMoNhomId);
        return ResponseEntity.ok(nhomHocs);
    }

    @PostMapping("/assign/manual/{keHoachMoNhomId}")
    public ResponseEntity<List<NhomHoc>> assignLecturersManually(
            @PathVariable String keHoachMoNhomId,
            @RequestBody Map<String, Integer> lecturerAssignments) {
        List<NhomHoc> nhomHocs = nhomHocService.assignLecturersManually(keHoachMoNhomId, lecturerAssignments);
        return ResponseEntity.ok(nhomHocs);
    }

    @PostMapping("/assign/auto/{keHoachMoNhomId}")
    public ResponseEntity<List<NhomHoc>> assignLecturersAutomatically(@PathVariable String keHoachMoNhomId) {
        List<NhomHoc> nhomHocs = nhomHocService.assignLecturersAutomatically(keHoachMoNhomId);
        return ResponseEntity.ok(nhomHocs);
    }

    @GetMapping
    public ResponseEntity<List<NhomHoc>> getAllNhomHoc() {
        List<NhomHoc> nhomHocs = nhomHocService.getAllNhomHoc();
        return ResponseEntity.ok(nhomHocs);
    }



    @GetMapping("/giangvien/{giangVienId}")
    public ResponseEntity<List<NhomHoc>> getNhomHocByGiangVien(@PathVariable String giangVienId) {
        List<NhomHoc> nhomHocs = nhomHocService.getNhomHocByGiangVien(giangVienId);
        return ResponseEntity.ok(nhomHocs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhomHoc(@PathVariable String id) {
        nhomHocService.deleteNhomHoc(id);
        return ResponseEntity.noContent().build();
    }
}