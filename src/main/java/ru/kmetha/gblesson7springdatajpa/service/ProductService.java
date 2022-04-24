package ru.kmetha.gblesson7springdatajpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kmetha.gblesson7springdatajpa.dao.ProductDao;
import ru.kmetha.gblesson7springdatajpa.entity.Product;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findById(Long id) {
        return productDao.findById(id).orElseThrow(NullPointerException::new);
    }

    public Product save(Product product) {
        return productDao.save(product);
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }
}
