package com.tu.simpleWebApp.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Component
public class Product {
    private int prodId;
    private String prodName;
    private int price;
    private String category;
    private int soLuongBan;
    private LocalDate dateCreate;


    public Product() {
    }

    public Product(int prodId, String prodName, int price, String category, int soLuongBan, LocalDate dateCreate) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
        this.category = category;
        this.soLuongBan = soLuongBan;
        this.dateCreate = dateCreate;
    }

    public int getProdId() {
        return prodId;
    }

    public int getPrice() {
        return price;
    }

    public String getProdName() {
        return prodName;
    }

    public String getCategory() {
        return category;
    }


    public int getSoLuongBan() {
        return soLuongBan;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }
}
