package com.example.cafe.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sanpham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ten;
    private double gia;
    private int tonKho;

    public SanPham() {}

    public SanPham(String ten, double gia, int tonKho) {
        this.ten = ten;
        this.gia = gia;
        this.tonKho = tonKho;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }

    public double getGia() { return gia; }
    public void setGia(double gia) { this.gia = gia; }

    public int getTonKho() { return tonKho; }
    public void setTonKho(int tonKho) { this.tonKho = tonKho; }
}
