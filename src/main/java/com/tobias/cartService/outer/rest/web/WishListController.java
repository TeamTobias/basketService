package com.tobias.cartService.outer.rest.web;

import com.tobias.cartService.inner.domain.*;
import com.tobias.cartService.inner.service.CartService;
import com.tobias.cartService.inner.service.WishListService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class WishListController {
    private final WishListService wishListService;

    @PostMapping("/myWishList/v1/{userId}")
    public HttpStatus addWishItem(@PathVariable("userId") int userId, @RequestBody RequestWishItem item) {
        wishListService.addWishList(userId, item);
        return HttpStatus.OK;
    }

    @GetMapping("/myWishList/v1/{userId}")
    public ResponseEntity<ResponseWishList> userWishListPage(@PathVariable("userId") int userId) {
        WishList wishList = wishListService.getWishListByUserId(userId);

        Iterable<WishItem> wishItems = wishListService.getWishItemsByWishListId(wishList.getId());

        ResponseWishList responseWishList = new ResponseWishList();
        responseWishList.setId(wishList.getId());
        responseWishList.setUserId(wishList.getUserId());
        responseWishList.setWishItems(wishItems);
        responseWishList.setCount(wishList.getCount());
        return ResponseEntity.status(HttpStatus.OK).body(responseWishList);
    }

    @DeleteMapping("/myWishList/v1/{wishItemId}")
    public HttpStatus deleteWishItem(@PathVariable("wishItemId") int wishItemId) {
        wishListService.deleteWishItemById(wishItemId);
        return HttpStatus.OK;
    }


}
