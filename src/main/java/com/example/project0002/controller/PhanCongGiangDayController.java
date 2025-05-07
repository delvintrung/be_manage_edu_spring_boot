package com.example.project0002.controller;

import com.example.project0002.model.PhanCongGiangDay;
import com.example.project0002.service.PhanCongGiangDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/phanconggiangday")
public class PhanCongGiangDayController {

    @Autowired
    private PhanCongGiangDayService phanCongGiangDayService;

    // Create
    @PostMapping
    public ResponseEntity<?> createPhanCongGiangDay(@RequestBody PhanCongGiangDay phanCongGiangDay) {
        try {
            PhanCongGiangDay createdPhanCongGiangDay = phanCongGiangDayService.createPhanCongGiangDay(phanCongGiangDay);
            return ResponseEntity.ok(createdPhanCongGiangDay);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<PhanCongGiangDay>> getAllPhanCongGiangDay() {
        List<PhanCongGiangDay> phanCongGiangDayList = phanCongGiangDayService.getAllPhanCongGiangDay();
        return ResponseEntity.ok(phanCongGiangDayList);
    }

    // Read (by keHoachMoNhomId)
    @GetMapping(params = "keHoachMoNhomId")
    public ResponseEntity<List<PhanCongGiangDay>> getPhanCongGiangDayByKeHoachMoNhomId(@RequestParam String keHoachMoNhomId) {
        List<PhanCongGiangDay> phanCongGiangDayList = phanCongGiangDayService.getPhanCongGiangDayByKeHoachMoNhomId(keHoachMoNhomId);
        return ResponseEntity.ok(phanCongGiangDayList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<?> getPhanCongGiangDayById(@PathVariable String id) {
        PhanCongGiangDay phanCongGiangDay = phanCongGiangDayService.getPhanCongGiangDayById(id);
        if (phanCongGiangDay == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Phân công giảng dạy không tồn tại");
        }
        return ResponseEntity.ok(phanCongGiangDay);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePhanCongGiangDay(@PathVariable String id, @RequestBody PhanCongGiangDay phanCongGiangDayDetails) {
        try {
            PhanCongGiangDay updatedPhanCongGiangDay = phanCongGiangDayService.updatePhanCongGiangDay(id, phanCongGiangDayDetails);
            if (updatedPhanCongGiangDay == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Phân công giảng dạy không tồn tại");
            }
            return ResponseEntity.ok(updatedPhanCongGiangDay);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePhanCongGiangDay(@PathVariable String id) {
        try {
            phanCongGiangDayService.deletePhanCongGiangDay(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}