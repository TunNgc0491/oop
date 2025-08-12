package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class GiaoDich {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Khóa chính tự tăng

    @ManyToOne
    @JoinColumn(name = "ma_kh", nullable = false)
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "ma_sp", nullable = false)
    private SanPham sanPham;

    private LocalDateTime thoiGian;

    public GiaoDich() {}

    public GiaoDich(KhachHang khachHang, SanPham sanPham, LocalDateTime thoiGian) {
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.thoiGian = thoiGian;
    }

    // Getter/Setter
    public Long getId() { return id; }
    public KhachHang getKhachHang() { return khachHang; }
    public void setKhachHang(KhachHang khachHang) { this.khachHang = khachHang; }
    public SanPham getSanPham() { return sanPham; }
    public void setSanPham(SanPham sanPham) { this.sanPham = sanPham; }
    public LocalDateTime getThoiGian() { return thoiGian; }
    public void setThoiGian(LocalDateTime thoiGian) { this.thoiGian = thoiGian; }
}
