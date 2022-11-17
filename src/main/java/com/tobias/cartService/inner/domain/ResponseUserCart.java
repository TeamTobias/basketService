package com.tobias.cartService.inner.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUserCart {
   private User user;
   private Iterable<CartItem> cartItems;
   private int totalCount;
   private int totalPrice;
}
