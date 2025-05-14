package com.example.project0002.controller;

import com.example.project0002.model.KeHoachDayHoc_NganhHoc;
import com.example.project0002.service.KeHoachDayHocNganhHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kehoachdayhocnganhhoc")
public class KeHoachDayHocNganhHocController {

    @Autowired
    private KeHoachDayHocNganhHocService service;

    @GetMapping("/api/nganhhoc/{nganhHocId}")
    public ResponseEntity<List<KeHoachDayHoc_NganhHoc>> getByNganhHocId(@PathVariable String nganhHocId) {
        List<KeHoachDayHoc_NganhHoc> result = service.getByNganhHocId(nganhHocId);
        return ResponseEntity.ok(result);
    }
}