package com.example.webshop_backend.service;

import com.example.webshop_backend.model.Basket;
//import com.example.webshop_backend.model.Category;
import com.example.webshop_backend.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    private final BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }
    public void saveBasket(Basket basketToCreate){
        Basket basket = new Basket();
        basket.setBasketItems(basketToCreate.getBasketItems());
        basketRepository.save(basket);
    }
    public Basket updateBasket(Basket basketToUpdate){
        basketToUpdate.setBasketItems(basketToUpdate.getBasketItems());
        basketRepository.save(basketToUpdate);
        return basketToUpdate;
    }
    public List<Basket> getBasket(){
        return basketRepository.findAll();
    }
    public Optional<Basket> findById(int id){
        return basketRepository.findById(id);
    }
    public void deleteBasket(int id){
        basketRepository.deleteById(id);
    }
}
