package com.example.project0002.service;

import com.example.project0002.model.KeHoachDayHoc_NganhHoc;
import com.example.project0002.repository.KeHoachDayHocNganhHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class KeHoachDayHocNganhHocService {

    @Autowired
    private KeHoachDayHocNganhHocRepository repository;
    @Transactional
    public KeHoachDayHoc_NganhHoc createKeHoachDayHocNganhHoc(KeHoachDayHoc_NganhHoc keHoachNganhHoc) {
        return repository.save(keHoachNganhHoc);
    }



    public List<KeHoachDayHoc_NganhHoc> getByNganhHocId(String nganhHocId) {
        return repository.findByNganhHocId(nganhHocId);
    }
}