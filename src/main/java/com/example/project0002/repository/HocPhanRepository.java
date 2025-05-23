package com.example.project0002.repository;

import com.example.project0002.model.HocPhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HocPhanRepository extends JpaRepository<HocPhan, String> {
    Optional<HocPhan> findByTen(String ten);

    Integer countHocPhanByNganhHoc_Id(String nganhHocId);

    @Query(value = "SELECT SUM(CAST(tin_chi AS UNSIGNED)) FROM hocphan WHERE nganh_hoc_id = :nganhHocId", nativeQuery = true)
    Integer sumTinChiByNganhHocId(@Param("nganhHocId") String nganhHocId);

    List<HocPhan> findAllByNganhHoc_Id(String nganhHocId);
}