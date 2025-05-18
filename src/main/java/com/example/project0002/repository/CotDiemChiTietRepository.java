package com.example.project0002.repository;

import com.example.project0002.model.CotDiemChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CotDiemChiTietRepository extends JpaRepository<CotDiemChiTiet, String> {
    List<CotDiemChiTiet> findByDeCuongChiTietId(String deCuongId);
}
