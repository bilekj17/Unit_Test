package com.example.eshop;

import com.example.eshop.product.DigitalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DigitalProductTest {
    @Test
    @DisplayName("Should create valid product with all atributes")
    void createNewDigitalProduct() {
        String name = "E-book java 2025";
        String description = "This is the description";
        BigDecimal price = new BigDecimal("49.90");
        String url = "https://seznam.cz";

        //ACT 1
        DigitalProduct product = new DigitalProduct(name, description, price, url);

        assertAll("Verify product attributes",
                () -> assertEquals(name, product.getName(), "name should match"),
                () -> assertEquals(description, product.getDescription(), "Description should match"),
                () -> assertEquals(price, product.getPrice(), "Price should match"),
                () -> assertEquals(url, product.getDownloadUrl(), "Download url should match"));
    }
}
