package com.shop.e_shop.service;

import com.shop.e_shop.model.Favorite;
import com.shop.e_shop.model.Product;
import com.shop.e_shop.model.User;
import com.shop.e_shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserService userService;
    @Autowired
    FavoriteService favoriteService;

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
    public List<Product> getNewProducts(){
        List<Product> products = findAllProducts();
        Collections.reverse(products);
        return products.stream().limit(18).collect(Collectors.toList());
    }

    public List<Product> getFavUserProducts(Integer userId){
        List<Product> favProducts = new ArrayList<>();
        Optional<User> foundUser = userService.findUser(userId);
        if (foundUser.isPresent()){
            List<Favorite> userFavorite = favoriteService.findAllUserFavorites(foundUser.get());
            for (Favorite fav : userFavorite){
                favProducts.add(fav.getIdProduct());
            }
        }
        return favProducts ;
    }

    public Integer countFavoriteProducts(Integer productId){
        Optional<Product> foundProduct = findProduct(productId);
        List<Favorite> productFavs = new ArrayList<>();
        if(foundProduct.isPresent()){
            productFavs = favoriteService.findAllFavoriteByProduct(foundProduct.get());
        }
        return productFavs.size();
    }

    public Integer countUserFavoriteProducts(Integer userId ) {
        Optional<User> foundUser = userService.findUser(userId);
        List<Favorite> userFavorite = new ArrayList<>();
        if (foundUser.isPresent()) {
            userFavorite = favoriteService.findAllUserFavorites(foundUser.get());
        }
        return userFavorite.size();
    }


}
