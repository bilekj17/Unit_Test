package com.example.eshop;

import com.example.eshop.cart.Cart;
import com.example.eshop.product.PhysicalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CartBilekjTest {
    @Test
    @DisplayName("Add")
    void addCartBilekjTest() {

        Cart cart = new Cart();
        PhysicalProduct jablko = new PhysicalProduct("Jablko","červené", new BigDecimal(20), 20,new BigDecimal(20));
        cart.addItem(jablko, 2);

        assertAll("Verify add product",
                () -> assertEquals(jablko, cart.getItems().get(0).getProduct(), "Item should be same")
        );
    }

    @Test
    @DisplayName("Remove")
    void removeCartBilekjTest() {

        Cart cart = new Cart();
        PhysicalProduct jablko = new PhysicalProduct("Jablko","červené", new BigDecimal(20), 20,new BigDecimal(20));
        cart.addItem(jablko, 2);

        cart.removeItem(jablko);
        assertAll("Verify add product",
                () -> assertEquals(0, cart.getItems().size(), "Item should be null")
        );
    }
}
