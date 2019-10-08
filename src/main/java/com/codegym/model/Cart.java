package com.codegym.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<Long,Product> productMap= new HashMap<>();

    public List<Product> getProductCart() {
        return new ArrayList<>(productMap.values());
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
