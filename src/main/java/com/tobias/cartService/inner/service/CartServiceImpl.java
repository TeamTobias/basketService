package com.tobias.cartService.inner.service;

import com.tobias.cartService.inner.domain.Cart;
import com.tobias.cartService.inner.domain.CartItem;
import com.tobias.cartService.inner.domain.RequestItem;
import com.tobias.cartService.inner.repository.CartItemRepository;
import com.tobias.cartService.inner.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    public Iterable<Cart> getCartsAll(){
        return cartRepository.findAll();
    }

    @Transactional
    public void addCart(int userId, RequestItem item, int amount) {
        // 유저 id로 해당 유저의 장바구니 찾기

        Cart cart = cartRepository.findByUserId(userId);

        // 장바구니가 존재하지 않는다면
        if (cart == null) {
            cart = Cart.createCart(userId);
            cartRepository.save(cart);
        }

        CartItem cartItem = cartItemRepository.findByCartIdAndItemId(cart.getId(), item.getId());

        // 상품이 장바구니에 존재하지 않거나 같더라도 색상, 사이즈가 다르다면 카트상품 생성 후 추가
        if (cartItem == null || cartItem.getColor() != item.getColor() || cartItem.getSize() != item.getSize()) {
            cartItem = CartItem.createCartItem(cart.getId(), item, amount);
            cartItemRepository.save(cartItem);
        }

        // 상품이 장바구니에 이미 존재한다면 수량만 증가
        else {
            CartItem update = cartItem;
            update.setCartId(cartItem.getCartId());
            update.setItemId(cartItem.getItemId());
            update.setName(cartItem.getName());
            update.addCount(amount);
            update.setCount(update.getCount()+1);
            cartItemRepository.save(update);
        }
        // 카트 상품 총 개수 증가
        cart.setCount(cart.getCount()+1);
    }

    @Override
    public Cart getCartByUserId(int userId) {
        return cartRepository.findByUserId(userId);
    }

    @Override
    public Iterable<CartItem> getCartItemsByCart(Cart userCart) {
        return cartItemRepository.findByCartId(userCart.getId());
    }

    @Override
    public void deleteCartItemById(int id) {
        cartItemRepository.deleteById(id);
    }
}
