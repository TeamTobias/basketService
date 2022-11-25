package com.tobias.cartService.outer.rest.web;

import com.tobias.cartService.inner.service.CartService;
import com.tobias.cartService.inner.service.WishListService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WishListController {
    private final WishListService wishListService;
}
