package com.example.project0002.service;

import com.example.project0002.model.CotDiemChiTiet;
import com.example.project0002.repository.CotDiemChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CotDiemChiTietService {

    @Autowired
    private CotDiemChiTietRepository cotDiemChiTietRepository;

    public List<CotDiemChiTiet> findByDeCuongChiTietId(String deCuongId) {
        return cotDiemChiTietRepository.findByDeCuongChiTietId(deCuongId);
    }
}