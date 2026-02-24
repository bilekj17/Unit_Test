package com.example.eshop;

import com.example.eshop.cart.CartItem;
import com.example.eshop.product.DigitalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.Parameter;
import org.junit.jupiter.params.ParameterizedClass;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
@ParameterizedClass
@ValueSource(ints = { -1, 0, Integer.MIN_VALUE})
class CartItemBilekjTest {
    @Parameter
    int quantity;

    @Test
    @DisplayName("CartItem")
    void CartItemBilekjTest() {
        DigitalProduct dp = new DigitalProduct("jablko", "", new BigDecimal(2000), "");

        // test if negative quantity is covered in constructor
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new CartItem(dp, quantity);
                }
        );
    }

    @Test
    @DisplayName("setQuantity")
    void setQuantityBilekjTest() {
        DigitalProduct dp = new DigitalProduct("jablko", "", new BigDecimal(2000), "");

        // test if negative quantity is covered in setter
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    CartItem ci = new CartItem(dp, 1);
                    ci.setQuantity(quantity);
                }
        );
    }
}
