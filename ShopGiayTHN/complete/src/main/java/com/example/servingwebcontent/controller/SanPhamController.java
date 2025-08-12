package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.repository.SanPhamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sanpham")
public class SanPhamController {

    private final SanPhamRepository sanPhamRepository;

    public SanPhamController(SanPhamRepository sanPhamRepository) {
        this.sanPhamRepository = sanPhamRepository;
    }

    // Lấy tất cả sản phẩm
    @GetMapping
    public List<SanPham> getAllSanPham() {
        return sanPhamRepository.findAll();
    }

    // Lấy sản phẩm theo mã
    @GetMapping("/{maSp}")
    public ResponseEntity<SanPham> getSanPhamById(@PathVariable String maSp) {
        Optional<SanPham> sp = sanPhamRepository.findById(maSp);
        return sp.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Thêm sản phẩm mới
    @PostMapping
    public SanPham createSanPham(@RequestBody SanPham sanPham) {
        return sanPhamRepository.save(sanPham);
    }

    // Cập nhật sản phẩm
    @PutMapping("/{maSp}")
    public ResponseEntity<SanPham> updateSanPham(@PathVariable String maSp, @RequestBody SanPham sanPhamDetails) {
        return sanPhamRepository.findById(maSp)
                .map(sp -> {
                    sp.setName(sanPhamDetails.getName());
                    sp.setPrice(sanPhamDetails.getPrice());
                    sp.setSize(sanPhamDetails.getSize());
                    sp.setImageURL(sanPhamDetails.getImageURL());
                    return ResponseEntity.ok(sanPhamRepository.save(sp));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Xóa sản phẩm
    @DeleteMapping("/{maSp}")
    public ResponseEntity<Void> deleteSanPham(@PathVariable String maSp) {
        if (sanPhamRepository.existsById(maSp)) {
            sanPhamRepository.deleteById(maSp);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
