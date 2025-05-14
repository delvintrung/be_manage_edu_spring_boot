package com.example.project0002.controller;

import com.example.project0002.model.KhoiKienThuc;
import com.example.project0002.service.KhoiKienThucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khoikienthuc")
public class KhoiKienThucController {

    @Autowired
    private KhoiKienThucService nhomKienThucService;

    // Create
    @PostMapping
    public ResponseEntity<KhoiKienThuc> createNhomKienThuc(@RequestBody KhoiKienThuc nhomKienThuc) {
        KhoiKienThuc createdNhomKienThuc = nhomKienThucService.createNhomKienThuc(nhomKienThuc);
        return ResponseEntity.ok(createdNhomKienThuc);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<KhoiKienThuc>> getAllNhomKienThuc() {
        List<KhoiKienThuc> nhomKienThucList = nhomKienThucService.getAllNhomKienThuc();
        return ResponseEntity.ok(nhomKienThucList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<KhoiKienThuc> getNhomKienThucById(@PathVariable String id) {
        KhoiKienThuc nhomKienThuc = nhomKienThucService.getNhomKienThucById(id);
        return ResponseEntity.ok(nhomKienThuc);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<KhoiKienThuc> updateNhomKienThuc(@PathVariable String id, @RequestBody KhoiKienThuc nhomKienThucDetails) {
        KhoiKienThuc updatedNhomKienThuc = nhomKienThucService.updateNhomKienThuc(id, nhomKienThucDetails);
        return ResponseEntity.ok(updatedNhomKienThuc);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhomKienThuc(@PathVariable String id) {
        nhomKienThucService.deleteNhomKienThuc(id);
        return ResponseEntity.noContent().build();
    }
}