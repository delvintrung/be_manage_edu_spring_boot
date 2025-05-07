package com.example.project0002.service;

import com.example.project0002.model.ThongTinChungCTDT;
import com.example.project0002.repository.ThongTinChungCTDTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThongTinChungCTDTService {

    @Autowired
    private ThongTinChungCTDTRepository repository;

    public List<ThongTinChungCTDT> findAll() {
        return repository.findAll();
    }

    public Optional<ThongTinChungCTDT> findById(String id) {
        return repository.findById(id);
    }

    public ThongTinChungCTDT save(ThongTinChungCTDT thongTinChungCTDT) {
        return repository.save(thongTinChungCTDT);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }
}