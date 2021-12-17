package com.example.webshop_backend.api;

import com.example.webshop_backend.model.Basket;
import com.example.webshop_backend.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/basket/")
    public List<Basket> getAllBaskets(){
        return basketService.getBasket();
    }
    @GetMapping("/basket/{id}")
    public Optional<Basket> getAllBaskets(@PathVariable Integer id){
        return basketService.findById(id);
    }
    @PostMapping("/basket/new")
    public String addProductToBasket(@RequestBody @Valid Basket basket){
        basketService.saveBasket(basket);
        return "redirect:/basket";
    }

    @DeleteMapping("/basket/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProductFromBasket(@PathVariable Integer id){
      //  User user = UserService.findById(id)
      //  .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
      basketService.deleteBasket(id);
      Map<String, Boolean> response = new HashMap<>();
      response.put("deleted", Boolean.TRUE);
      return ResponseEntity.ok(response);
    }

    @PutMapping("/basket/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable Integer id, @RequestBody @Valid Basket basketEdited){
        Basket basket = basketService.findById(id)
        //User user = userRepository.findById(id)
        .orElseThrow(() -> new NullPointerException("Basket does not exist with id :" + id));
        basket.setProducts(basketEdited.getProducts()); //tut es ersetzten oder hinzufügen?
        basket.setProductQuantity(basketEdited.getProductQuantity());
        Basket updatedBasket = basketService.updateBasket(basket);
        return ResponseEntity.ok(updatedBasket);
    }

}
