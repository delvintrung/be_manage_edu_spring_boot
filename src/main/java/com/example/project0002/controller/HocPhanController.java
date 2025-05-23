package com.example.project0002.controller;

import com.example.project0002.model.HocPhan;
import com.example.project0002.service.HocPhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hocphan")
public class HocPhanController {

    @Autowired
    private HocPhanService hocPhanService;

    // Create
    @PostMapping
    public ResponseEntity<HocPhan> createHocPhan(@RequestBody HocPhan hocPhan) {
        HocPhan createdHocPhan = hocPhanService.createHocPhan(hocPhan);
        return ResponseEntity.ok(createdHocPhan);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<HocPhan>> getAllHocPhan() {
        List<HocPhan> hocPhanList = hocPhanService.getAllHocPhan();
        return ResponseEntity.ok(hocPhanList);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<HocPhan>> getFilterHocPhan(@RequestParam("nganhHocId") String nganhHocId) {
        List<HocPhan> list = hocPhanService.getFilterHocPhan(nganhHocId);
        return ResponseEntity.ok(list);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<HocPhan> getHocPhanById(@PathVariable String id) {
        HocPhan hocPhan = hocPhanService.getHocPhanById(id);
        return ResponseEntity.ok(hocPhan);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<HocPhan> updateHocPhan(@PathVariable String id, @RequestBody HocPhan hocPhanDetails) {
        HocPhan updatedHocPhan = hocPhanService.updateHocPhan(id, hocPhanDetails);
        return ResponseEntity.ok(updatedHocPhan);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHocPhan(@PathVariable String id) {
        hocPhanService.deleteHocPhan(id);
        return ResponseEntity.noContent().build();
    }
}