package com.example.project0002.repository;

import com.example.project0002.model.KhoiKienThuc_KhungChuongTrinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoiKienThucKhungChuongTrinhRepository extends JpaRepository<KhoiKienThuc_KhungChuongTrinh, String> {
}
