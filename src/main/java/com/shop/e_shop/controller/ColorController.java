package com.shop.e_shop.controller;

import com.shop.e_shop.model.Color;
import com.shop.e_shop.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/colors")
    public void createColor(@RequestBody Color color){
        colorService.saveColor(color);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping("/colors/{id}")
    public void deleteColor(@PathVariable("id") Integer id){
        colorService.deleteColor(id);
    }


}
