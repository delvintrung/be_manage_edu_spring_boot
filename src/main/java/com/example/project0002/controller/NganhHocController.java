package com.example.project0002.controller;

import com.example.project0002.dto.NganhHocDto;
import com.example.project0002.model.NganhHoc;
import com.example.project0002.service.NganhHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nganhhoc")
public class NganhHocController {

    @Autowired
    private NganhHocService nganhHocService;

    // Create
    @PostMapping
    public ResponseEntity<NganhHoc> createNganhHoc(@RequestBody NganhHoc nganhHoc) {
        NganhHoc createdNganhHoc = nganhHocService.createNganhHoc(nganhHoc);
        return ResponseEntity.ok(createdNganhHoc);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<NganhHocDto>> getAllNganhHoc() {
        List<NganhHocDto> nganhHocList = nganhHocService.getAllNganhHoc();
        return ResponseEntity.ok(nganhHocList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<NganhHoc> getNganhHocById(@PathVariable String id) {
        NganhHoc nganhHoc = nganhHocService.getNganhHocById(id);
        return ResponseEntity.ok(nganhHoc);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<NganhHoc> updateNganhHoc(@PathVariable String id, @RequestBody NganhHoc nganhHocDetails) {
        NganhHoc updatedNganhHoc = nganhHocService.updateNganhHoc(id, nganhHocDetails);
        return ResponseEntity.ok(updatedNganhHoc);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNganhHoc(@PathVariable String id) {
        nganhHocService.deleteNganhHoc(id);
        return ResponseEntity.noContent().build();
    }
}