package com.example.webshop_backend.api;

import com.example.webshop_backend.model.Basket;
import com.example.webshop_backend.model.BasketItem;
import com.example.webshop_backend.repository.BasketRepository;
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
    private BasketRepository basketRepository;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/baskets")
    public List<Basket> getAllBaskets() {
        return basketService.getBasket();
    }

    @GetMapping("/basket/{id}")
    public Optional<Basket> getAllBaskets(@PathVariable Integer id) {
        return basketService.findById(id);
    }

    @PostMapping("/basket/new")
    public String addProductToBasket(@RequestBody @Valid Basket basket) {
        return basketService.saveBasket(basket);
    }

    @DeleteMapping("/basket/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteProductFromBasket(@PathVariable Integer id) {
        //  User user = UserService.findById(id)
        //  .orElseThrow(() -> new ResourceNotFoundException("User does not exist with id :" + id));
        basketService.deleteBasket(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/basket/update/{basket_id}")
    public Basket updateBasket(@PathVariable Integer basket_id, @RequestBody @Valid Basket basketEdited) {
        Basket basket = basketService.findById(basket_id)

        //User user = userRepository.findById(id)
        .orElseThrow(() -> new NullPointerException("Basket does not exist with id :" + basket_id));
        BasketItem basketItem = new BasketItem();
        //basket.setBasketItems(basketEdited.getBasketItems());
        return basketService.updateBasket(basketEdited);
    }

}
