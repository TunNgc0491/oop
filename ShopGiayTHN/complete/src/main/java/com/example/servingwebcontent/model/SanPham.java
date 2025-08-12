package com.example.servingwebcontent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SanPham {

    @Id
    private String maSp;    // Mã sản phẩm (Primary Key)
    private String name;    // Tên sản phẩm
    private double price;   // Giá
    private int size;       // Kích thước
    private String imageURL; // Link ảnh

    public SanPham() {}

    public SanPham(String maSp, String name, double price, int size, String imageURL) {
        this.maSp = maSp;
        this.name = name;
        this.price = price;
        this.size = size;
        this.imageURL = imageURL;
    }

    public SanPham(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter/Setter
    public String getMaSp() { return maSp; }
    public void setMaSp(String maSp) { this.maSp = maSp; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
    public String getImageURL() { return imageURL; }
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }
}
