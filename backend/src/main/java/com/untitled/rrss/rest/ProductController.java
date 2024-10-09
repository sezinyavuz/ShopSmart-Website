package com.untitled.rrss.rest;

import com.untitled.rrss.entity.Product;
import com.untitled.rrss.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    private ProductService productService;

    public ProductController (ProductService theProductService) {
        productService = theProductService;
    }
    @GetMapping("/product")
    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/product/{productId}")
    public Product findById(@PathVariable int productId) {
        return productService.findById(productId);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product theProduct) {
        theProduct.setId(0);

        Product dbProduct = productService.save(theProduct);
        return dbProduct;
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product theProduct) {

        Product dbProduct = productService.save(theProduct);
        return dbProduct;
    }

    @DeleteMapping("/product/{productId}")
    public String deleteProduct(@PathVariable int productId) {

        Product tempProduct = productService.findById(productId);

        if (tempProduct == null) {
            throw new RuntimeException("Product id not found - " + productId);
        }

        productService.deleteById(productId);

        return "Deleted product by id - " + productId;

    }
}
