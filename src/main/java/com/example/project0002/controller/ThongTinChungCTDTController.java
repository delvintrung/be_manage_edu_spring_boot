package com.example.project0002.controller;

import com.example.project0002.model.ThongTinChungCTDT;
import com.example.project0002.service.ThongTinChungCTDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/thongtinchungctdt")
public class ThongTinChungCTDTController {

    @Autowired
    private ThongTinChungCTDTService service;

    @GetMapping
    public List<ThongTinChungCTDT> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThongTinChungCTDT> getById(@PathVariable String id) {
        Optional<ThongTinChungCTDT> thongTin = service.findById(id);
        return thongTin.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ThongTinChungCTDT create(@RequestBody ThongTinChungCTDT thongTin) {
        return service.save(thongTin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThongTinChungCTDT> update(@PathVariable String id, @RequestBody ThongTinChungCTDT thongTin) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        thongTin.setId(id);
        return ResponseEntity.ok(service.save(thongTin));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}