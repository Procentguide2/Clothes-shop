package com.shop.e_shop.repository;

import com.shop.e_shop.model.Favorite;
import com.shop.e_shop.model.Product;
import com.shop.e_shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> getAllByIdUser(User idUser);
    List<Favorite> getAllByIdProduct(Product idProduct);
    void deleteByIdUserAndIdProduct(User idUser, Product idProduct);
    Favorite findFavoriteByIdUserAndIdProduct(User idUser, Product idProduct);
}