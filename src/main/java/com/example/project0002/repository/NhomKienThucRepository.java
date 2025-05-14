package com.example.project0002.repository;

import com.example.project0002.model.KhoiKienThuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NhomKienThucRepository extends JpaRepository<KhoiKienThuc, String> {
    Optional<KhoiKienThuc> findByTen(String ten);
}