package com.example.project0002.controller;

import com.example.project0002.model.KhoiKienThuc_KeHoachDayHoc;
import com.example.project0002.service.KhoiKienThucKeHoachDayHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khoikienthuckehoachdayhoc")
public class KhoiKienThucKeHoachDayHocController {

    @Autowired
    private KhoiKienThucKeHoachDayHocService service;

    @GetMapping("/api/kehoachdayhoc/{keHoachDayHocId}")
    public ResponseEntity<List<KhoiKienThuc_KeHoachDayHoc>> getByKeHoachDayHocId(@PathVariable String keHoachDayHocId) {
        List<KhoiKienThuc_KeHoachDayHoc> result = service.getByKeHoachDayHocId(keHoachDayHocId);
        return ResponseEntity.ok(result);
    }
}