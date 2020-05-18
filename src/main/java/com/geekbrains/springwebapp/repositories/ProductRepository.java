package com.geekbrains.springwebapp.repositories;

import com.geekbrains.springwebapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findOneByTitle(String title);
}