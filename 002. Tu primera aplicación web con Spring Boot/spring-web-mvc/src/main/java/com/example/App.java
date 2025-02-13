package com.example;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.CategoryRepostory;
import com.example.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        var repository = context.getBean(ProductRepository.class);
        var repositoryCategory = context.getBean(CategoryRepostory.class);

        List<Product> products = List.of(
                new Product(null, "Pantalón", 5.99, 1),
                new Product(null, "Sudadera", 6.99, 2),
                new Product(null, "Zapatos", 7.99, 4),
                new Product(null, "Mancuerna", 8.99, 2),
                new Product(null, "Rodillera", 8.99, 2),
                new Product(null, "Balón", 8.99, 2),
                new Product(null, "Zapatillas", 69.99, 20)
        );
        repository.saveAll(products);

        List<Category> categories = List.of(
                new Category("Deporte", "Equipamiento deportivo", "https://img.freepik.com/foto-gratis/herramientas-deportivas_53876-138077.jpg", true),
                new Category("Calzado", "Calzado para los pies", "https://img.freepik.com/foto-gratis/par-zapatos-hierba-otono_23-2147869604.jpg?t=st=1739436892~exp=1739440492~hmac=a9fb21098d19e7c54c869c141b3880d71932ebf8e6d71b22d979186e6705a7e1&w=900", true)
        );
        repositoryCategory.saveAll(categories);

        products.get(0).setCategory(categories.get(0));
        products.get(1).setCategory(categories.get(0));
        products.get(2).setCategory(categories.get(1));
        products.get(3).setCategory(categories.get(0));
        products.get(4).setCategory(categories.get(0));
        products.get(5).setCategory(categories.get(0));
        products.get(6).setCategory(categories.get(1));

    }

}
