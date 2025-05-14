package com.example.project0002.repository;

import com.example.project0002.model.KhoiKienThuc_KeHoachDayHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhoiKienThucKeHoachDayHocRepository extends JpaRepository<KhoiKienThuc_KeHoachDayHoc, String> {
    List<KhoiKienThuc_KeHoachDayHoc> findByKeHoachDayHocId(String keHoachDayHocId);
}