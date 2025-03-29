package com.amazon.service;

import com.amazon.entity.Cart;
import com.amazon.entity.Order;

public interface CartService {

    Cart addItemToCart(String productId, int quantity);

    Cart getCartForUserId(String userId);

    Order checkoutCart(Cart cart);

}
