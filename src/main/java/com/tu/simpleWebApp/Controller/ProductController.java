package com.tu.simpleWebApp.Controller;

import com.tu.simpleWebApp.Model.Product;
import com.tu.simpleWebApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;


    @RequestMapping("/products")
    public List<Product>  getProducts(){
        return service.getProducts();
    }

    @RequestMapping("/products/{category}")
    public List<Product>  getProductByCategory(@PathVariable String category)
    {
        return service.getProductsByCategory(category);
    }
    @RequestMapping("/products/top10")
    public List<Product> getProductBanChay(@RequestParam(defaultValue = "10") int soLuongBan)
    {
        return service.getProductsBanChay(soLuongBan);
    }

    @RequestMapping("/products/7day")
    public  List<Product> getProducts7Day(LocalDate dateCreate)
    {
        return service.getProducts7Day(dateCreate);

    }

}
