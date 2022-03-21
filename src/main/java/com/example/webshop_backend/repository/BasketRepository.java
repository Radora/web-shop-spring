package com.example.webshop_backend.repository;

import com.example.webshop_backend.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends CrudRepository<Basket,Integer> {
    Basket findBasketById(int basketid);
}
