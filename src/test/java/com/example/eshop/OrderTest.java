package com.example.eshop;

import com.example.eshop.cart.CartItem;
import com.example.eshop.order.OrderStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class OrderTest {
    @Test
    @DisplayName("Atributes")
    void createNewOrder(){
        UUID id = UUID.randomUUID();
        List<CartItem> items = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
        LocalDateTime orderDate = LocalDateTime.now();
        OrderStatus status = OrderStatus.PENDING;


    }
}
