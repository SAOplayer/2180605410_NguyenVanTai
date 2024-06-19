package com.hutech.NguyenVanTai.Repository;

import com.hutech.NguyenVanTai.Models.phongban;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhongBanRepository extends JpaRepository<phongban, Long>{
}
