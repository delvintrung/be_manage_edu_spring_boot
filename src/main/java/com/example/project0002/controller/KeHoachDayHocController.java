package com.example.project0002.controller;

import com.example.project0002.model.KeHoachDayHoc;
import com.example.project0002.service.KeHoachDayHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kehoachdayhoc")
public class KeHoachDayHocController {

    @Autowired
    private KeHoachDayHocService keHoachDayHocService;

    // Create
    @PostMapping
    public ResponseEntity<KeHoachDayHoc> createKeHoachDayHoc(@RequestBody KeHoachDayHoc keHoachDayHoc) {
        System.out.println(keHoachDayHoc.getNganhHocId());
        KeHoachDayHoc createdKeHoachDayHoc = keHoachDayHocService.createKeHoachDayHoc(keHoachDayHoc);

        return ResponseEntity.ok(createdKeHoachDayHoc);
    }

    @GetMapping("/search")
    public ResponseEntity<List<KeHoachDayHoc>> searchKeHoachDayHoc(
            @RequestParam(required = false) Integer hocKy,
            @RequestParam(required = false) String nganhHocId) {
        List<KeHoachDayHoc> keHoachDayHocs = keHoachDayHocService.findByHocKyAndNganhHocId(hocKy, nganhHocId);
        return ResponseEntity.ok(keHoachDayHocs);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<KeHoachDayHoc>> getAllKeHoachDayHoc() {
        List<KeHoachDayHoc> keHoachDayHocList = keHoachDayHocService.getAllKeHoachDayHoc();
        return ResponseEntity.ok(keHoachDayHocList);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<KeHoachDayHoc> getKeHoachDayHocById(@PathVariable String id) {
        KeHoachDayHoc keHoachDayHoc = keHoachDayHocService.getKeHoachDayHocById(id);
        return ResponseEntity.ok(keHoachDayHoc);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<KeHoachDayHoc> updateKeHoachDayHoc(@PathVariable String id, @RequestBody KeHoachDayHoc keHoachDayHocDetails) {
        KeHoachDayHoc updatedKeHoachDayHoc = keHoachDayHocService.updateKeHoachDayHoc(id, keHoachDayHocDetails);
        return ResponseEntity.ok(updatedKeHoachDayHoc);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKeHoachDayHoc(@PathVariable String id) {
        keHoachDayHocService.deleteKeHoachDayHoc(id);
        return ResponseEntity.noContent().build();
    }
}