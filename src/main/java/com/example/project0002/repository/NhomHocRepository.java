package com.example.project0002.repository;

import com.example.project0002.model.NhomHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhomHocRepository extends JpaRepository<NhomHoc, String> {
    List<NhomHoc> findByKeHoachMoNhomId(String keHoachMoNhomId);
    List<NhomHoc> findByGiangVienId(String giangVienId);
    Optional<NhomHoc> findByKeHoachMoNhomIdAndMaNhom(String keHoachMoNhomId, int maNhom);
}