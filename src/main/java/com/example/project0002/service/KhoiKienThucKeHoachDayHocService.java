package com.example.project0002.service;

import com.example.project0002.model.KhoiKienThuc_KeHoachDayHoc;
import com.example.project0002.repository.KhoiKienThucKeHoachDayHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoiKienThucKeHoachDayHocService {

    @Autowired
    private KhoiKienThucKeHoachDayHocRepository repository;

    public List<KhoiKienThuc_KeHoachDayHoc> getByKeHoachDayHocId(String keHoachDayHocId) {
        return repository.findByKeHoachDayHocId(keHoachDayHocId);
    }
}