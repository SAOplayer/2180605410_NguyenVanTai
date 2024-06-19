package com.hutech.NguyenVanTai.controller;


import com.hutech.NguyenVanTai.Models.phongban;
import com.hutech.NguyenVanTai.service.phongbanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class PhongBanController {
    @Autowired
    private final phongbanService phongBanService;
    @GetMapping("/phongban/add")
    public String showAddForm(Model model) {
        model.addAttribute("phongban", new phongban());
        return "/phongban/add-phongban";
    }
    @PostMapping("/phongban/add")
    public String addPhongBan(@Valid phongban phongBan, BindingResult result) {
        if (result.hasErrors()) {
            return "/phongban/add-phongban";
        }
        phongBanService.addPhongBan(phongBan);
        return "redirect:/phongban";
    }
    // Hiển thị danh sách danh mục
    @GetMapping("/phongban")
    public String listphongban(Model model) {
        List<phongban> phongBans = phongBanService.getAllPhongBan();
        model.addAttribute("phongban",phongBans);
        return "/phongban/phongban-list";
    }

    @GetMapping("/phongban/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        phongban phongBan = phongBanService.getPhongBanById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid phongban Id:"
                        + id));
        model.addAttribute("phongban", phongBan);
        return "/phongban/update-phongban";
    }
    // POST request to update category
    @PostMapping("/phongban/update/{id}")
    public String updatephongban(@PathVariable("id") Long id, @Valid phongban phongBan,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            phongBan.setId(id);
            return "/phongban/update-phongban";
        }
        phongBanService.updatePhongBan(phongBan);
        model.addAttribute("phongban", phongBanService.getAllPhongBan());
        return "redirect:/phongban";
    }
    // GET request for deleting category
    @GetMapping("/phongban/delete/{id}")
    public String deletephongban(@PathVariable("id") Long id, Model model) {
        phongban phongBan = phongBanService.getPhongBanById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid phongban Id:"
                        + id));
        phongBanService.deletePhongBanById(id);
        model.addAttribute("phongban", phongBanService.getAllPhongBan());
        return "redirect:/phongban";
    }
}
