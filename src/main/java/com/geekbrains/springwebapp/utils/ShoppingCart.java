package com.geekbrains.springwebapp.utils;

import com.geekbrains.springwebapp.entities.Product;
import com.geekbrains.springwebapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private List<Product> products;
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> getProducts() {
        return products;
    }

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
    }

    public void addProductById(Long id){
        Product product = productService.getProductById(id);
        products.add(product);
    }
}
