package com.example.eshop;

import com.example.eshop.cart.Cart;
import com.example.eshop.order.Order;
import com.example.eshop.order.OrderService;
import com.example.eshop.order.OrderStatus;
import com.example.eshop.payment.PaymentProcessor;
import com.example.eshop.product.PhysicalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceBilekjTest {

    @Test
    @DisplayName("placeOrder - empty cart throws exception")
    void placeOrderEmptyCartThrows() {

        // Vytvoříme falešný PaymentProcessor.
        // Pokud by se náhodou zavolal, test okamžitě selže.
        PaymentProcessor paymentProcessor = amount -> {
            fail("PaymentProcessor should not be called for empty cart!");
            return false;
        };

        // Vytvoříme testovanou službu
        OrderService orderService = new OrderService(paymentProcessor);

        // Vytvoříme prázdný košík
        Cart cart = new Cart();

        // Očekáváme výjimku, protože nelze vytvořit objednávku z prázdného košíku
        IllegalStateException ex = assertThrows(
                IllegalStateException.class,
                () -> orderService.placeOrder(cart)
        );

        // Ověříme správnou chybovou zprávu
        assertEquals("Cannot place an order with an empty cart", ex.getMessage());
    }

    @Test
    @DisplayName("placeOrder - payment success => order PAID and cart cleared")
    void placeOrderPaymentSuccess() {

        // Falešný PaymentProcessor, který vždy vrátí úspěšnou platbu
        PaymentProcessor paymentProcessor = amount -> true;

        OrderService orderService = new OrderService(paymentProcessor);

        // Vytvoříme košík a přidáme produkt
        Cart cart = new Cart();
        PhysicalProduct jablko = new PhysicalProduct(
                "Jablko",
                "červené",
                new BigDecimal("20"),
                20,
                new BigDecimal("20")
        );

        cart.addItem(jablko, 2);

        // Zavoláme testovanou metodu
        Order order = orderService.placeOrder(cart);

        // Ověříme více podmínek najednou
        assertAll("Verify successful payment",
                // Objednávka musí existovat
                () -> assertNotNull(order),

                // Stav objednávky musí být PAID
                () -> assertEquals(OrderStatus.PAID, order.getStatus()),

                // Košík musí být po objednání vymazán
                () -> assertTrue(cart.getItems().isEmpty())
        );
    }

    @Test
    @DisplayName("placeOrder - payment fail => order CANCELLED and cart cleared")
    void placeOrderPaymentFail() {

        // Falešný PaymentProcessor, který vždy vrátí neúspěšnou platbu
        PaymentProcessor paymentProcessor = amount -> false;

        OrderService orderService = new OrderService(paymentProcessor);

        // Vytvoříme košík a přidáme produkt
        Cart cart = new Cart();
        PhysicalProduct jablko = new PhysicalProduct(
                "Jablko",
                "červené",
                new BigDecimal("20"),
                20,
                new BigDecimal("20")
        );

        cart.addItem(jablko, 2);

        // Zavoláme testovanou metodu
        Order order = orderService.placeOrder(cart);

        assertAll("Verify failed payment",
                // Objednávka musí existovat
                () -> assertNotNull(order),

                // Stav objednávky musí být CANCELLED
                () -> assertEquals(OrderStatus.CANCELLED, order.getStatus()),

                // Košík se musí vymazat i při neúspěšné platbě
                () -> assertTrue(cart.getItems().isEmpty())
        );
    }
}