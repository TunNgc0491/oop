package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.SanPham;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SanPhamRepository extends JpaRepository<SanPham, String> {

    List<SanPham> findAll();

    Optional<SanPham> findById(String maSp);
}
