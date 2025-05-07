package com.example.project0002.service;

import com.example.project0002.model.KeHoachMoNhom;
import com.example.project0002.repository.KeHoachMoNhomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KeHoachMoNhomService {

    @Autowired
    private KeHoachMoNhomRepository keHoachMoNhomRepository;

    public KeHoachMoNhom createKeHoachMoNhom(KeHoachMoNhom keHoachMoNhom) {
        return keHoachMoNhomRepository.save(keHoachMoNhom);
    }

    public List<KeHoachMoNhom> getAllKeHoachMoNhom() {
        return keHoachMoNhomRepository.findAll();
    }

    public Optional<KeHoachMoNhom> getKeHoachMoNhomById(String id) {
        return keHoachMoNhomRepository.findById(id);
    }

    public KeHoachMoNhom updateKeHoachMoNhom(String id, KeHoachMoNhom updatedKeHoachMoNhom) {
        Optional<KeHoachMoNhom> existing = keHoachMoNhomRepository.findById(id);
        if (existing.isPresent()) {
            KeHoachMoNhom keHoachMoNhom = existing.get();
            keHoachMoNhom.setHocPhan(updatedKeHoachMoNhom.getHocPhan());
            keHoachMoNhom.setKhoa(updatedKeHoachMoNhom.getKhoa());
            keHoachMoNhom.setSoSinhVien(updatedKeHoachMoNhom.getSoSinhVien());
            keHoachMoNhom.setSoSinhVienMotLop(updatedKeHoachMoNhom.getSoSinhVienMotLop());
            return keHoachMoNhomRepository.save(keHoachMoNhom);
        }
        return null;
    }

    public void deleteKeHoachMoNhom(String id) {
        keHoachMoNhomRepository.deleteById(id);
    }

    public int calculateSoLop(KeHoachMoNhom keHoachMoNhom) {
        int soSinhVien = keHoachMoNhom.getSoSinhVien();
        int soSinhVienMotLop = keHoachMoNhom.getSoSinhVienMotLop();
        if (soSinhVienMotLop > 0) {
            return (int) Math.ceil((double) soSinhVien / soSinhVienMotLop);
        }
        return 0;
    }
}