package com.shop.e_shop.service;

import com.shop.e_shop.model.Color;
import com.shop.e_shop.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

    @Autowired
    ColorRepository colorRepository;

    public List<Color> findAllColors(){
        return colorRepository.findAll();
    }

    public Optional<Color> findColor(Integer id){
        return colorRepository.findById(id);
    }

    public void saveColor(Color color){
        colorRepository.save(color);
    }

    public void deleteColor(Integer id){
        colorRepository.deleteById(id);
    }

}
