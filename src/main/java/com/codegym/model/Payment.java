package com.codegym.model;

public class Payment {
    private String name;
    private float price;
    private float count;
    private float total;
    private String model;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Payment(long id, String name, String price, String count, String model){
        this.name=name;
        this.count=Float.parseFloat(count);
        this.price=Float.parseFloat(price);
        this.total=this.count*this.price;
        this.model=model;
        this.id=id;
    }
}
