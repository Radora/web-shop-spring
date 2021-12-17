package com.example.webshop_backend.service;

import com.example.webshop_backend.model.Basket;
import com.example.webshop_backend.model.Category;
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
    public void saveBasket(Basket basket){
        basketRepository.save(basket);
    }
    public Basket updateBasket(Basket basket){
       basketRepository.save(basket);
        return basket;
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
