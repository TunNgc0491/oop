package com.example.servingwebcontent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.servingwebcontent.model.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
}
