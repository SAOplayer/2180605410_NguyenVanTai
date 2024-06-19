package com.hutech.NguyenVanTai.Models;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NhanVien")
public class nhanvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String MaNv;
    private String TenNv;
    private String Phai;
    private double Luong;
    private String NoiSinh;
    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private phongban phongBan;
}
