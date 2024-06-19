package com.hutech.NguyenVanTai.controller;

import com.hutech.NguyenVanTai.Models.nhanvien;
import com.hutech.NguyenVanTai.service.nhanvienService;
import com.hutech.NguyenVanTai.service.phongbanService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/nhanvien")
public class nhanvienController {
    @Autowired
    private nhanvienService nhanVienService;
    @Autowired
    private phongbanService phongBanService;

    @GetMapping
    public String showProductList(Model model) {
        model.addAttribute("nhanvien", nhanVienService.getAllNhanvien());
        return "/nhanvien/nhanvien-list";
    }
    // For adding a new product
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("nhanvien", new nhanvien());
        model.addAttribute("phongban", phongBanService.getAllPhongBan());
        return "/nhanvien/add-nhanvien";
    }
    @PostMapping("/add")
    public String addnhanvien(@Valid nhanvien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            return "/nhanvien/add-nhanvien";
        }
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        nhanvien nhanVien = nhanVienService.getNhanVienById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid nhanvien Id:" + id));
        model.addAttribute("nhanvien", nhanVien);
        model.addAttribute("phongban", phongBanService.getAllPhongBan());
        return "/nhanvien/update-nhanvien";
    }
    // Process the form for updating a product
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @Valid nhanvien nhanVien, BindingResult result) {
        if (result.hasErrors()) {
            nhanVien.setId(id); //
            return "/nhanvien/update-nhanvien";
        }

        nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhanvien";
    }
    // Handle request to delete a product
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {

        nhanVienService.deleteNhanVienById(id);
        return "redirect:/nhanvien";
    }
}
