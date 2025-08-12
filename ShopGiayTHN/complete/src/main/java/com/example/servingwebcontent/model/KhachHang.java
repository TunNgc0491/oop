package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class KhachHang {
    @Id
    private String maKh;
    private String ten;
    private String sdt;

    public KhachHang() {}

    public KhachHang(String maKh, String ten, String sdt) {
        this.maKh = maKh;
        this.ten = ten;
        this.sdt = sdt;
    }

    // getters and setters...
    public String getMaKh() { return maKh; }
    public void setMaKh(String maKh) { this.maKh = maKh; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
}