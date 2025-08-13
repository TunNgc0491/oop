package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.KhachHang;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

    List<KhachHang> findAll();

    boolean existsById(String maKh);

    KhachHang save(KhachHang khachHang);

    Optional<KhachHang> findById(String maKh);

    void deleteById(String maKh);
}
