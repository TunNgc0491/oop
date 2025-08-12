package com.example.servingwebcontent.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SanPham {
    @Id
    private String maSp;
    private String name;
    private double price;
    private int size;
    private String imageURL;

    public SanPham() {}

    public SanPham(String maSp, String name, double price, int size, String imageURL) {
        this.maSp = maSp;
        this.name = name;
        this.price = price;
        this.size = size;
        this.imageURL = imageURL;
    }

    // getters and setters...
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