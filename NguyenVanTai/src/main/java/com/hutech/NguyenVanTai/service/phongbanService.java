package com.hutech.NguyenVanTai.service;

import com.hutech.NguyenVanTai.Models.phongban;
import com.hutech.NguyenVanTai.Repository.PhongBanRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class phongbanService {
    private final PhongBanRepository phongBanRepository;

    public List<phongban> getAllPhongBan() {
        return phongBanRepository.findAll();
    }

    public Optional<phongban> getPhongBanById(Long id) {
        return phongBanRepository.findById(id);
    }

    public void addPhongBan(phongban phongBan) {
        phongBanRepository.save(phongBan);
    }

    public void updatePhongBan(@NotNull phongban phongBan) {
        phongban existingPhongBan = phongBanRepository.findById(phongBan.getId())
                .orElseThrow(() -> new IllegalStateException("Category with ID " +
                        phongBan.getId() + " does not exist."));
        existingPhongBan.setMaPhong(phongBan.getMaPhong());
        existingPhongBan.setTenPhong(phongBan.getTenPhong());
        phongBanRepository.save( existingPhongBan);
    }
    public void deletePhongBanById(Long id) {
        if (! phongBanRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does not exist.");
        }
        phongBanRepository.deleteById(id);
    }
}


