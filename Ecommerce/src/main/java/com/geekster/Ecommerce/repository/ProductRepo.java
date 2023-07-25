package com.geekster.Ecommerce.repository;

import com.geekster.Ecommerce.factory.BeanFactory;
import com.geekster.Ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class ProductRepo {
    @Autowired

    Map<Integer, Product> products;

    public Map<Integer, Product> getProductList() {
        return products;
    }
}
