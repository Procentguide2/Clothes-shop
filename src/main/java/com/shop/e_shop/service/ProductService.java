package com.shop.e_shop.service;

import com.shop.e_shop.model.Product;
import com.shop.e_shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> findProduct(Integer id){
        return productRepository.findById(id);
    }

    public List<Product> getAllByGender(String gender){
        return productRepository.getProductsByGender(gender);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
