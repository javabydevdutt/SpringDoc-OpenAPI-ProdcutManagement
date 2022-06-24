package com.devdutt.management.controller;

import com.devdutt.management.entity.Product;
import com.devdutt.management.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ProductRestController", description = "Rest APi related to Product Entity")
@RestController
@RequestMapping("/api")
@SecurityRequirement(name = "prod-api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    /**
     * Takes Product Object as input and returns save Status as ResponseEntity<String>
     */
    @Operation(summary = "store product in database")
    @PostMapping("/products")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productRepository.save(product));
    }

    /**
     * To retrieve all Product, returns data retrieval Status as ResponseEntity<?>
     */
    @Operation(summary = "get All the product from database")
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    /**
     * To retrieve one Product by providing id, returns Product object & Status as ResponseEntity<?>
     */
    @Operation(summary = "get  one product from database")
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getOneProducts(@PathVariable int id) {
        return ResponseEntity.ok(productRepository.findById(id).get());
    }

    /**
     * To delete one Product by providing id, returns Status as ResponseEntity<String>
     */
    @Operation(summary = "delete product from database")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        ResponseEntity<String> resp = null;
        try {
            productRepository.deleteById(id);
            resp = new ResponseEntity<String>("Product '" + id + "' deleted", HttpStatus.OK); //200-Ok
        } catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseEntity<String>("Unable to delete product", HttpStatus.INTERNAL_SERVER_ERROR); //500-Internal Server Error
        }
        return resp;
    }
}
