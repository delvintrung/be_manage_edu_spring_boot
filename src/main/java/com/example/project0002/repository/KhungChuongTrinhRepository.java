package com.example.project0002.repository;

import com.example.project0002.model.ChuongTrinhKhung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhungChuongTrinhRepository extends JpaRepository<ChuongTrinhKhung, String> {
}