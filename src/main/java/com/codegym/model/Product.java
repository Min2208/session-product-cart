package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    private int count=1;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = ++count;
    }

    private String img;
    private String name;
    private String price;
    private String model;

    public Product(String img, String name, String price, String model) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.model = model;
    }

    public Product(){}

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
