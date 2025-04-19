package com.example.project0002.repository;

import com.example.project0002.model.PhanCongGiangDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhanCongGiangDayRepository extends JpaRepository<PhanCongGiangDay, String> {
}