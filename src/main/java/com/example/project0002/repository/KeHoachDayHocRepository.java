package com.example.project0002.repository;

import com.example.project0002.model.KeHoachDayHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KeHoachDayHocRepository extends JpaRepository<KeHoachDayHoc, String> {
    @Query("SELECT k FROM KeHoachDayHoc k " +
            "LEFT JOIN KeHoachDayHoc_NganhHoc kn ON k.id = kn.keHoachDayHoc.id " +
            "WHERE (:hocKy IS NULL OR k.hocKy = :hocKy) " +
            "AND (:nganhHocId IS NULL OR kn.nganhHoc.id = :nganhHocId OR k.nganhHocId = :nganhHocId)")
    List<KeHoachDayHoc> findByHocKyAndNganhHocId(
            @Param("hocKy") Integer hocKy,
            @Param("nganhHocId") String nganhHocId);
}