package com.shop.e_shop.controller;

import com.shop.e_shop.model.Favorite;
import com.shop.e_shop.model.Product;
import com.shop.e_shop.model.User;
import com.shop.e_shop.repository.FavoriteRepository;
import com.shop.e_shop.service.FavoriteService;
import com.shop.e_shop.service.ProductService;
import com.shop.e_shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    FavoriteService favoriteService;
    @Autowired
    FavoriteRepository favoriteRepository;

    @GetMapping("/product")
    public List<Product> getNewProduct(){
        List<Product> products = productService.findAllProducts();
        Collections.reverse(products);
        return products.stream().limit(18).collect(Collectors.toList());
    }

    @GetMapping("/product/fav/{id}")
    public List<Product> getFavUserProducts(@PathVariable("id") Integer userId){
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

    @GetMapping("/product/for/{gender}")
    public List<Product> getAllByGender(@PathVariable("gender") String gender){
        return productService.getAllByGender(gender);
    }

    @GetMapping("/product/{id}")
    public Optional<Product> findProduct(@PathVariable("id") Integer id){
        return productService.findProduct(id);
    }

    @GetMapping("/product/count/fav/{productId}")
    public Integer countFavoriteProducts(@PathVariable("productId") Integer productId){
        int count = 0;
        Optional<Product> foundProduct = productService.findProduct(productId);
        if(foundProduct.isPresent()){
            List<Favorite> productFavs = favoriteRepository.getAllByIdProduct(foundProduct.get());
            for (Favorite fav : productFavs){
                count += 1;
            }
        }
        return count;
    }

    @GetMapping("/product/count/user/fav/{id}")
    public Integer countUserFavoriteProducts(@PathVariable("id") Integer userId ) {
        int count = 0;
        Optional<User> foundUser = userService.findUser(userId);
        if (foundUser.isPresent()) {
            List<Favorite> userFavorite = favoriteService.findAllUserFavorites(foundUser.get());
            for (Favorite fav : userFavorite) {
                count += 1;
            }
        }
        return count;
    }


    @PostMapping("/product/fav")
    public void addFavorite(@RequestBody Favorite favorite){
        favoriteService.saveFavorite(favorite);
    }

    @DeleteMapping("/product/fav/{id}")
    public void deleteFavorite(@PathVariable("id") Integer id){
        favoriteService.deleteFavorite(id);
    }

}
