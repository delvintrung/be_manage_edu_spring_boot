package com.example.project0002.repository;

import com.example.project0002.model.CotDiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CotDiemRepository extends JpaRepository<CotDiem, String> {
    Optional<CotDiem> findByTenCotDiem(String tenCotDiem);
}