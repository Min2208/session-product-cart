package com.codegym.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private static Map<Long,Product> productMap;
    static {
        productMap=new HashMap<>();



    }

    List<Product> productCart=new ArrayList<>();

    public List<Product> getProductCart() {
        return new ArrayList<>(productMap.values());
    }

    public void setProductCart(List<Product> productCart) {
        this.productCart = productCart;
    }

    public void addCart(Product product) {
        System.out.println(productMap.containsKey(product.getId()));
           productMap.put(product.getId(),product);
    }

    public int getSize(){
        return productMap.size();
    }

    public boolean contain(long id){
        return productMap.containsKey(id);
    }

    public void remove(long id){
        productMap.remove(id);
    }
}
