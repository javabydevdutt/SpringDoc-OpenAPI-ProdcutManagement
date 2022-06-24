package com.devdutt.management.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCT_TAB")
public class Product {

    @Id
    @GeneratedValue
    @Schema(name = "id", title = "test-id", description = "Product Id")
    private Integer id;

    @Schema(description = "name of the product", name = "name", title = "test-name")
    private String name;

    @Schema(description = "qty of the product", name = "qty", title = "test-qty")
    private Integer qty;

    @Schema(description = "amount of the product", name = "amount", title = "test-amount")
    private Double amount;

    @Schema(description = "finalAmount of the product", name = "finalAmount", title = "test-finalAmount")
    private Double finalAmount;
}
