package com.example.project0002.repository;

import com.example.project0002.model.ThongTinChungCTDT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThongTinChungCTDTRepository extends JpaRepository<ThongTinChungCTDT, String> {
}