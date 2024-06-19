package com.hutech.NguyenVanTai.service;

import com.hutech.NguyenVanTai.Models.nhanvien;
import com.hutech.NguyenVanTai.Repository.NhanVienRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class nhanvienService {

    private final NhanVienRepository nhanvienRepository;
    // Retrieve all products from the database
    public List<nhanvien> getAllNhanvien() {
        return nhanvienRepository.findAll();
    }
    // Retrieve a product by its id
    public Optional<nhanvien> getNhanVienById(Long id) {
        return nhanvienRepository.findById(id);
    }
    // Add a new product to the database
    public nhanvien addNhanVien(nhanvien nhanVien) {
        return nhanvienRepository.save(nhanVien);
    }
    // Update an existing product
    public nhanvien updateNhanVien(@NotNull nhanvien nhanVien) {
        nhanvien existingNhanVien =nhanvienRepository.findById(nhanVien.getId())
                .orElseThrow(() -> new IllegalStateException("Product with ID " +
                        nhanVien.getId() + " does not exist."));
        existingNhanVien.setTenNv(nhanVien.getTenNv());
        existingNhanVien.setMaNv(nhanVien.getMaNv());
        existingNhanVien.setPhai(nhanVien.getPhai());
        existingNhanVien.setLuong(nhanVien.getLuong());
        existingNhanVien.setNoiSinh(nhanVien.getNoiSinh());
        existingNhanVien.setPhongBan(nhanVien.getPhongBan());

        return nhanvienRepository.save(existingNhanVien);
    }
    // Delete a product by its id
    public void deleteNhanVienById(Long id) {
        if (!nhanvienRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        nhanvienRepository.deleteById(id);
    }
}
