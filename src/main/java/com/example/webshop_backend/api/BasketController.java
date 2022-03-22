package com.example.webshop_backend.api;

import com.example.webshop_backend.model.Basket;
import com.example.webshop_backend.model.BasketItem;
import com.example.webshop_backend.model.Product;
import com.example.webshop_backend.repository.BasketItemRepository;
import com.example.webshop_backend.repository.BasketRepository;
import com.example.webshop_backend.repository.ProductRepository;
import com.example.webshop_backend.repository.UserRepository;
import com.example.webshop_backend.service.BasketService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BasketController {

    private final BasketService basketService;
    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final BasketItemRepository basketItemRepository;


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

    @PostMapping("/basket/update/{product_id}")
    public String updateBasket(@PathVariable Integer product_id) {
        final String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        Basket basket = userRepository.findByUsername(userName).getBasket();
        Optional<Product> product = productRepository.findById(product_id);

        List<BasketItem> basketItems = basket.getBasketItems();

        BasketItem basketItem = new BasketItem();

        basketItem.setBasket(basket);
        basketItem.setProduct(product.get());
        basketItem.setProductQuantity(1);

        basketItems.add(basketItem);

        basketItemRepository.save(basketItem);
        basketRepository.save(basket);

       return "Product added to Basket";
    }
}
