package sen300.basketservice;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.*;

@RestController
@RequestMapping("/basket")
public class BasketRestController {

    @Autowired
    private RedisTemplate<String, Basket> redisTemplate;

    @PostMapping(path = "/{basketId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Basket addSingleBookToBasket(@PathVariable String basketId, @RequestBody Book book) {
        Basket basket = null;

        if ("new".equals(basketId)) {
            basket = new Basket(UUID.randomUUID().toString());
        } else {
            basket = redisTemplate.opsForValue().get(basketId);
        }

        basket.getBooks().add(book);
        redisTemplate.opsForValue().set(basket.getBasketGuid(), basket);

        return basket;

    }

    @GetMapping(path = "/{basketId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Basket getBasket(@PathVariable String basketId) {
        Basket basket = redisTemplate.opsForValue().get(basketId);
        return basket;
    }

    @DeleteMapping(path = "/{basketId}/{bookUUID}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteBookFromBasket(@PathVariable String basketId, @PathVariable UUID bookUUID) {
        Basket basket = redisTemplate.opsForValue().get(basketId);

        basket.setBooks(
                basket.getBooks().stream().filter(b -> !b.getBookGuid().equals(bookUUID)).collect(Collectors.toList()));

        redisTemplate.opsForValue().set(basketId, basket);
    }

    @DeleteMapping(path = "/{basketId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteBasket(@PathVariable String basketId) {
        redisTemplate.delete(basketId);
    }

}