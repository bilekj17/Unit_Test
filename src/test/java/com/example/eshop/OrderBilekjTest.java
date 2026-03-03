package com.example.eshop;

import com.example.eshop.cart.Cart;
import com.example.eshop.cart.CartItem;
import com.example.eshop.order.Order;
import com.example.eshop.order.OrderStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderBilekjTest {
    @Test
    @DisplayName("Atributes")
    void createNewOrder(){
        //UUID id = UUID.randomUUID();
        List<CartItem> items = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;
        //LocalDateTime orderDate = LocalDateTime.now();
        OrderStatus status = OrderStatus.PENDING;

        Order order = new Order(new Cart());

        assertAll("Verify attributes",
                () -> assertNotNull(order.getId(), "id should match"),
                () -> assertEquals(items, order.getItems(), "Items should match"),
                () -> assertEquals(totalAmount, order.getTotalAmount(), "total amount should match"),
                () -> assertNotNull(order.getOrderDate(), "date should match"),
                () -> assertEquals(status, order.getStatus(), "Status should match"));
    }
}
