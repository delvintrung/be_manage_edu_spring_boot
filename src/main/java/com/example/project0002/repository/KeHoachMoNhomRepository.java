package com.example.project0002.repository;

import com.example.project0002.model.KeHoachMoNhom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeHoachMoNhomRepository extends JpaRepository<KeHoachMoNhom, String> {
}