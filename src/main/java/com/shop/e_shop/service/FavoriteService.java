package com.shop.e_shop.service;

import com.shop.e_shop.model.Favorite;
import com.shop.e_shop.model.User;
import com.shop.e_shop.repository.FavoriteRepository;
import com.shop.e_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {

    @Autowired
    FavoriteRepository favoriteRepository;


    public List<Favorite> findAllFavorites(){
        return favoriteRepository.findAll();
    }

    public List<Favorite> findAllUserFavorites(User user){
        return favoriteRepository.getAllByIdUser(user);
    }

    public Optional<Favorite> findFavorite(Integer id){
        return favoriteRepository.findById(id);
    }

    public void saveFavorite(Favorite favorite){
        favoriteRepository.save(favorite);
    }

    public void deleteFavorite(Integer id){
        favoriteRepository.deleteById(id);
    }

}