package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.KhachHang;
import com.example.servingwebcontent.repository.KhachHangRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

    private final KhachHangRepository khachHangRepository;

    public KhachHangController(KhachHangRepository khachHangRepository) {
        this.khachHangRepository = khachHangRepository;
    }

    // Lấy tất cả khách hàng
    @GetMapping
    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }

    // Lấy khách hàng theo mã
    @GetMapping("/{maKh}")
    public ResponseEntity<KhachHang> getKhachHangById(@PathVariable String maKh) {
        Optional<KhachHang> kh = khachHangRepository.findById(maKh);
        return kh.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm khách hàng mới
    @PostMapping
    public KhachHang createKhachHang(@RequestBody KhachHang khachHang) {
        return khachHangRepository.save(khachHang);
    }

    // Cập nhật khách hàng
    @PutMapping("/{maKh}")
    public ResponseEntity<KhachHang> updateKhachHang(@PathVariable String maKh, @RequestBody KhachHang khachHangDetails) {
        return khachHangRepository.findById(maKh)
                .map(kh -> {
                    kh.setTen(khachHangDetails.getTen());
                    kh.setSdt(khachHangDetails.getSdt());
                    return ResponseEntity.ok(khachHangRepository.save(kh));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Xóa khách hàng
    @DeleteMapping("/{maKh}")
    public ResponseEntity<Void> deleteKhachHang(@PathVariable String maKh) {
        if (khachHangRepository.existsById(maKh)) {
            khachHangRepository.deleteById(maKh);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
