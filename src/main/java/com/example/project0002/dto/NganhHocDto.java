package com.example.project0002.dto;

import com.example.project0002.model.Khoa;
import lombok.Data;

@Data
public class NganhHocDto {
    private String id;
    private String ten;
    private String moTa;
    private Khoa khoa;
    private int tongSoTinChi;
    private int tongSoHocPhan;
}
