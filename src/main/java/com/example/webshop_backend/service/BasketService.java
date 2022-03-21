package com.example.webshop_backend.service;

import com.example.webshop_backend.model.Basket;
//import com.example.webshop_backend.model.Category;
import com.example.webshop_backend.model.BasketItem;
import com.example.webshop_backend.model.Product;
import com.example.webshop_backend.model.User;
import com.example.webshop_backend.repository.BasketRepository;
import com.example.webshop_backend.security.CustomUserDetails;
import com.sun.xml.bind.v2.TODO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }
    public String saveBasket(Basket basketToCreate){
        BasketItem basketItem = new BasketItem();
        basketItem.setId(basketItem.getId());
        basketItem.setProductQuantity(basketItem.getProductQuantity());
        basketItem.setProduct(basketItem.getProduct());
//        basketItem.setBasket(basketItem.getBasket());
        basketRepository.save(basketToCreate);
        return "added Basket";
    }
    public Basket updateBasket(Basket basketToUpdate){
        BasketItem newItem = new BasketItem();
        newItem.setProductQuantity(newItem.getProductQuantity());
        basketRepository.save(basketToUpdate);
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = ((CustomUserDetails) auth.getPrincipal()).getUser();
//        Basket userBasket = user.getBasket();
//        userBasket.setBasketItems(basketToUpdate.getBasketItems());
//        basketRepository.save(userBasket);
            return basketToUpdate;
    }
    public List<Basket> getBasket(){
        return (List<Basket>) basketRepository.findAll();
    }
    public Optional<Basket> findById(int id){
        return basketRepository.findById(id);
    }
    public void deleteBasket(int id){
        basketRepository.deleteById(id);
    }
}
