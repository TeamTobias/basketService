package com.tobias.basketService.inner.service;

import com.tobias.basketService.inner.domain.*;
import com.tobias.basketService.inner.repository.WishItemRepository;
import com.tobias.basketService.inner.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService{

    private final WishListRepository wishListRepository;
    private final WishItemRepository wishItemRepository;

    public Iterable<WishList> getWishListAll(){
        return wishListRepository.findAll();
    }

    @Transactional
    public void addWishList(int userId, RequestWishItem item){
        WishList wishList  = wishListRepository.findByUserId(userId);

        if (wishList == null) {
            wishList = WishList.createWishList(userId);
            wishListRepository.save(wishList);
        }

        WishItem wishItem = wishItemRepository.findByWishListIdAndItemId(wishList.getId(), item.getId());

        if (wishItem == null) {
            WishItem newWishItem = WishItem.createWishItem(wishList.getId(), item);
            wishItemRepository.save(newWishItem);
            wishList.setCount(wishList.getCount() + 1);
        }
    }

    public WishList getWishListByUserId(int userId){
        return wishListRepository.findByUserId(userId);
    }

    public Iterable<WishItem> getWishItemsByWishListId(int wishListId){
        return wishItemRepository.findByWishListId(wishListId);
    }

    @Transactional
    @Override
    public void deleteWishItemById(int id) {
        WishItem wishItem = wishItemRepository.findById(id);
        WishList wishList = wishListRepository.findById(wishItem.getWishListId());
        wishList.setCount(wishList.getCount() - 1);
        wishItemRepository.deleteById(id);
    }
}
