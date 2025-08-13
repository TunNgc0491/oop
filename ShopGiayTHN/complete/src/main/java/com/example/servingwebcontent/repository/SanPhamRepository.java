package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.SanPham;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepository extends JpaRepository<SanPham, String> {

    Optional<SanPham> findById(String maSp);
    // Không cần khai báo lại các phương thức có sẵn
}
