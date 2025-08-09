package com.example.servingwebcontent.controller

import com.example.servingwebcontent.model.SanPham;
import com.example.servingwebcontent.repository.SanPhamRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sanpham")
@CrossOrigin(origins = "*")
public class SanPhamController {

    private final SanPhamRepository repo;

    public SanPhamController(SanPhamRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<SanPham> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public SanPham add(@RequestBody SanPham sp) {
        return repo.save(sp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SanPham> update(@PathVariable Long id, @RequestBody SanPham sp) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setTen(sp.getTen());
                    existing.setGia(sp.getGia());
                    existing.setTonKho(sp.getTonKho());
                    return ResponseEntity.ok(repo.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
