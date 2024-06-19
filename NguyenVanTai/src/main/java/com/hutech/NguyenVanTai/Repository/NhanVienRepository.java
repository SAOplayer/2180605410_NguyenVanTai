package com.hutech.NguyenVanTai.Repository;

import com.hutech.NguyenVanTai.Models.nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<nhanvien, Long> {
}
