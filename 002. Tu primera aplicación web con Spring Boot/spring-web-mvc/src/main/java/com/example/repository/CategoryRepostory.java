package com.example.repository;

import com.example.entity.Category;
import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepostory extends JpaRepository<Category, Long> {
    Optional<Category> findByName(String name);

    List<Category> findByImageIsNull();

    List<Category> findCategoriesByStateIsTrue();

    List<Category> findCategoriesByDescription(String text);
}

