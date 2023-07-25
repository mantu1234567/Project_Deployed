package com.geekster.Ecommerce.controller;

import com.geekster.Ecommerce.model.Category;
import com.geekster.Ecommerce.model.Product;
import com.geekster.Ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    // get all products;
    @GetMapping("get/all")
    public Map<Integer, Product> getAllProduct(){
        return productService.getProduct();
    }

    // add products or create product
    @PostMapping("products")
    public String addProducts(@RequestBody List<Product> products){

        return productService.addProducts(products);
    }
    //get all products below a particular price range
     @GetMapping("products/below/price/{price}")
    public List<Product> getBelowPrice(@PathVariable Double price){
        return productService.getBelowPrice(price);

    }
    @GetMapping("get/products/category/{category}")
    public List<Product> getProductsCategory(@PathVariable Category category){
        return productService.getProductsCategory(category);
    }
    @DeleteMapping("delete/products/{category}")
    public String deleteProduct(@PathVariable Category category){
        return productService.deleteProduct(category);
    }
    @PutMapping("products/discount/{discount}")
    public String updateProductByDiscount(@PathVariable Double discount)
    {
        return productService.updateProductByDiscount(discount);
    }
}
