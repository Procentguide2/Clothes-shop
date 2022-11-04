package com.shop.e_shop.controller;

import com.shop.e_shop.service.ColorService;
import com.shop.e_shop.model.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ColorController {

    @Autowired
    ColorService colorService;

    @GetMapping("/colors")
    public List<Color> getAllColors(){
        return colorService.findAllColors();
    }

    @GetMapping("/colors/{id}")
    public Optional<Color> findColor(@PathVariable("id") Integer id){
        return colorService.findColor(id);
    }

    @PostMapping("/colors")
    public void createColor(@RequestBody Color color){
        colorService.saveColor(color);
    }

    @DeleteMapping("/colors/{id}")
    public void deleteColor(@PathVariable("id") Integer id){
        colorService.deleteColor(id);
    }


}
