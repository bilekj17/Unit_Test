package com.example.eshop;

import com.example.eshop.product.PhysicalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PhysicalProductBilekjTest {
    @Test
    @DisplayName("Should create valid product with all atributes")
    void createNewPhysicalBilekjProduct() {
        String name = "E-book java 2020";
        String description = "This is the description:)";
        BigDecimal price = new BigDecimal("39.90");
        double weight = 100;
        BigDecimal shippingCost = new BigDecimal("100");
        //String url = "https://Google.com";

        PhysicalProduct product = new PhysicalProduct(name, description, price, weight, shippingCost);

        assertAll("Verify product attributes",
                () -> assertEquals(name, product.getName(), "name should match"),
                () -> assertEquals(description, product.getDescription(), "Description should match"),
                () -> assertEquals(price, product.getPrice(), "Price should match"),
                () -> assertEquals(weight, product.getWeight(), "Weight should match"),
                () -> assertEquals(shippingCost, product.getShippingCost(), "Shipping cost should match"));
                //() -> assertEquals(url, product.getDownloadUrl(), "Download url should match"));
    }
}
