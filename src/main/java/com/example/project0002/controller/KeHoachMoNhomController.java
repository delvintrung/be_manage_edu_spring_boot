package com.example.project0002.controller;

import com.example.project0002.model.KeHoachMoNhom;
import com.example.project0002.service.KeHoachMoNhomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/kehoachmonhom")
public class KeHoachMoNhomController {

    @Autowired
    private KeHoachMoNhomService keHoachMoNhomService;

    @PostMapping
    public ResponseEntity<KeHoachMoNhom> createKeHoachMoNhom(@RequestBody KeHoachMoNhom keHoachMoNhom) {
        KeHoachMoNhom created = keHoachMoNhomService.createKeHoachMoNhom(keHoachMoNhom);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<KeHoachMoNhom>> getAllKeHoachMoNhom() {
        List<KeHoachMoNhom> keHoachMoNhomList = keHoachMoNhomService.getAllKeHoachMoNhom();
        return ResponseEntity.ok(keHoachMoNhomList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeHoachMoNhom> getKeHoachMoNhomById(@PathVariable String id) {
        Optional<KeHoachMoNhom> keHoachMoNhom = keHoachMoNhomService.getKeHoachMoNhomById(id);
        return keHoachMoNhom.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<KeHoachMoNhom> updateKeHoachMoNhom(@PathVariable String id, @RequestBody KeHoachMoNhom keHoachMoNhom) {
        KeHoachMoNhom updated = keHoachMoNhomService.updateKeHoachMoNhom(id, keHoachMoNhom);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKeHoachMoNhom(@PathVariable String id) {
        keHoachMoNhomService.deleteKeHoachMoNhom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/so-lop")
    public ResponseEntity<Integer> calculateSoLop(@PathVariable String id) {
        Optional<KeHoachMoNhom> keHoachMoNhom = keHoachMoNhomService.getKeHoachMoNhomById(id);
        if (keHoachMoNhom.isPresent()) {
            int soLop = keHoachMoNhomService.calculateSoLop(keHoachMoNhom.get());
            return ResponseEntity.ok(soLop);
        }
        return ResponseEntity.notFound().build();
    }
}