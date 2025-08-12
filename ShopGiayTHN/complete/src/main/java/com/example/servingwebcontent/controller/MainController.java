package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.repository.GiaoDichRepository;
import com.example.servingwebcontent.repository.KhachHangRepository;
import com.example.servingwebcontent.repository.SanPhamRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    private final SanPhamRepository sanPhamRepository;
    private final KhachHangRepository khachHangRepository;
    private final GiaoDichRepository giaoDichRepository;

    public WebPageController(SanPhamRepository spRepo, KhachHangRepository khRepo, GiaoDichRepository gdRepo) {
        this.sanPhamRepository = spRepo;
        this.khachHangRepository = khRepo;
        this.giaoDichRepository = gdRepo;
    }

    @GetMapping("/")
    public String home() {
        return "main"; // Hoặc redirect về 1 trang chính, hoặc bạn có thể để main làm layout
    }

    @GetMapping("/sanpham")
    public String sanPhamPage(Model model) {
        List<SanPham> list = sanPhamRepository.findAll();
        model.addAttribute("sanphamList", list);
        return "sanpham";
    }

    @GetMapping("/khachhang")
    public String khachHangPage(Model model) {
        List<KhachHang> list = khachHangRepository.findAll();
        model.addAttribute("khachhangList", list);
        return "khachhang";
    }

    @GetMapping("/giaodich")
    public String giaoDichPage(Model model) {
        List<GiaoDich> list = giaoDichRepository.findAll();
        model.addAttribute("giaodichList", list);
        return "giaodich";
    }
}
