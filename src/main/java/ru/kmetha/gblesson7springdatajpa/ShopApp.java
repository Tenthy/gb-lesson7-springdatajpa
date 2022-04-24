package ru.kmetha.gblesson7springdatajpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kmetha.gblesson7springdatajpa.config.HibernateConfig;
import ru.kmetha.gblesson7springdatajpa.dao.ProductDao;
import ru.kmetha.gblesson7springdatajpa.service.ProductService;

public class ShopApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        ProductService service = context.getBean(ProductService.class);

        System.out.println(service.findById(1L).toString());
    }
}
