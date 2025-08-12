package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.GiaoDich;
import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.repository.GiaoDichRepository;
import com.example.servingwebcontent.repository.KhachHangRepository;
import com.example.servingwebcontent.repository.SanPhamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/giaodich")
public class GiaoDichController {

    private final GiaoDichRepository giaoDichRepository;
    private final KhachHangRepository khachHangRepository;
    private final SanPhamRepository sanPhamRepository;

    public GiaoDichController(GiaoDichRepository giaoDichRepository,
                              KhachHangRepository khachHangRepository,
                              SanPhamRepository sanPhamRepository) {
        this.giaoDichRepository = giaoDichRepository;
        this.khachHangRepository = khachHangRepository;
        this.sanPhamRepository = sanPhamRepository;
    }

    // Lấy tất cả giao dịch
    @GetMapping
    public List<GiaoDich> getAllGiaoDich() {
        return giaoDichRepository.findAll();
    }

    // Thêm giao dịch mới
    @PostMapping
    public ResponseEntity<?> createGiaoDich(@RequestParam String maKh, @RequestParam String maSp) {
        Optional<KhachHang> khOpt = khachHangRepository.findById(maKh);
        Optional<SanPham> spOpt = sanPhamRepository.findById(maSp);

        if (khOpt.isEmpty() || spOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Khách hàng hoặc sản phẩm không tồn tại");
        }

        GiaoDich gd = new GiaoDich(khOpt.get(), spOpt.get(), LocalDateTime.now());
        return ResponseEntity.ok(giaoDichRepository.save(gd));
    }

    // Xóa giao dịch
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGiaoDich(@PathVariable Long id) {
        if (giaoDichRepository.existsById(id)) {
            giaoDichRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
