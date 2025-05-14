package com.example.project0002.repository;

import com.example.project0002.model.KeHoachDayHoc_NganhHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeHoachDayHocNganhHocRepository extends JpaRepository<KeHoachDayHoc_NganhHoc, String> {
    List<KeHoachDayHoc_NganhHoc> findByNganhHocId(String nganhHocId);
}