package com.example.servingwebcontent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class KhachHang {

    @Id
    private String maKh; // Mã khách hàng (Primary Key)
    private String ten;  // Tên khách hàng
    private String sdt;  // Số điện thoại

    public KhachHang() {}

    public KhachHang(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    public KhachHang(String maKh, String ten, String sdt) {
        this.maKh = maKh;
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getMaKh() { return maKh; }
    public void setMaKh(String maKh) { this.maKh = maKh; }
    public String getTen() { return ten; }
    public void setTen(String ten) { this.ten = ten; }
    public String getSdt() { return sdt; }
    public void setSdt(String sdt) { this.sdt = sdt; }
}
