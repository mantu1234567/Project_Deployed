package com.geekster.Ecommerce.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.geekster.Ecommerce.model.Category;
import com.geekster.Ecommerce.model.Product;
import com.geekster.Ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
@Autowired
    ProductRepo productRepo;
    public Map<Integer,Product> getProduct() {
        return productRepo.getProductList();
    }

    public String addProducts(List<Product> products) {
        Map<Integer,Product> productList = getProduct();
        for(Product product:products) {
            productList.put(product.getProductId(),product);
        }
        return "Product are added !!!";
    }

    public List<Product> getBelowPrice(Double price) {
        List<Product> belowPriceList= new ArrayList<>();
        Map<Integer,Product> belowPriceMap=getProduct();
        for(Integer Id:belowPriceMap.keySet()){
            if(belowPriceMap.get(Id).getProductPrice()<=price){
                belowPriceList.add(belowPriceMap.get(Id));
            }

        }
        return belowPriceList;
    }

    public List<Product> getProductsCategory(Category category) {
        List<Product> productsList = new ArrayList<>();
        Map<Integer,Product> allMapList=getProduct();

        for(Integer Id: allMapList.keySet()){
            if(allMapList.get(Id).getProductCategory().equals(category)){
                productsList.add(allMapList.get(Id));
            }
        }
        return productsList;
    }

    public String deleteProduct(Category category) {
        Map<Integer,Product> mapList = getProduct();
        for(Integer Id : mapList.keySet()){
            if(mapList.get(Id).getProductCategory().equals(category)){
                mapList.remove(Id);
                return "Delete product";
            }
        }
        return "not delete frpom map";
    }
    public String updateProductByDiscount(Double discount) {
        Map<Integer, Product> productList = getProduct();
        for(Integer id : productList.keySet())
        {
            Double actualPrice = productList.get(id).getProductPrice();
            Double discountedPrice = actualPrice*(1-(discount/(100.0)));
            productList.get(id).setProductPrice(discountedPrice);

        }

        return "Price Updated";
    }
}
