package com.example.webshop_backend.service;

import com.example.webshop_backend.model.Basket;
//import com.example.webshop_backend.model.Category;
import com.example.webshop_backend.model.BasketItem;
import com.example.webshop_backend.repository.BasketItemRepository;
import com.example.webshop_backend.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final BasketItemRepository basketItemRepository;

    public BasketService(BasketRepository basketRepository, BasketItemRepository basketItemRepository) {
        this.basketRepository = basketRepository;
        this.basketItemRepository = basketItemRepository;
    }
    public String saveBasket(Basket basketToCreate){
        BasketItem basketItem = new BasketItem();
        basketItem.setId(basketItem.getId());
        basketItem.setProductQuantity(basketItem.getProductQuantity());
        basketItem.setProduct(basketItem.getProduct());
        basketItemRepository.save(basketItem);
        basketRepository.save(basketToCreate);
        return "added Basket";
    }
    public Basket updateBasket(Basket basketToUpdate){
        BasketItem newItem = new BasketItem();
        newItem.setProduct(newItem.getProduct());
        newItem.setProductQuantity(newItem.getProductQuantity());
        basketRepository.save(basketToUpdate);
        basketItemRepository.save(newItem);

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
