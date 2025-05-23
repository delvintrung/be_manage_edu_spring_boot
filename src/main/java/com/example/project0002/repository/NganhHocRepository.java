package com.example.project0002.repository;

import com.example.project0002.model.NganhHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NganhHocRepository extends JpaRepository<NganhHoc, String> {
    Optional<NganhHoc> findByTen(String ten);

}