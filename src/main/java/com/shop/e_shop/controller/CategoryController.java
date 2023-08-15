package com.shop.e_shop.controller;

import com.shop.e_shop.model.Category;
import com.shop.e_shop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.findAllCategories(), HttpStatus.OK);
    }
}
