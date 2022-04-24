package ru.kmetha.gblesson7springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kmetha.gblesson7springdatajpa.entity.Product;
import ru.kmetha.gblesson7springdatajpa.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/app")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String hello() {
        return productService.findById(1L).toString();
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Product> showAllProducts() {
        return productService.findAll();
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public Product showProductById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @RequestMapping(value = "/products/create", method = RequestMethod.POST)
    public Product save(HttpServletRequest request) {
        String title = request.getParameter("title");
        Long price = Long.valueOf(request.getParameter("price"));
        Product product = Product.builder().title(title).price(price).build();
        return productService.save(product);
    }

    @RequestMapping(value = "/products/delete/{id}", method = RequestMethod.GET)
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
