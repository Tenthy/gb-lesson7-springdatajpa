package ru.kmetha.gblesson7springdatajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kmetha.gblesson7springdatajpa.entity.Product;

public interface ProductDao extends JpaRepository<Product, Long> {
}
