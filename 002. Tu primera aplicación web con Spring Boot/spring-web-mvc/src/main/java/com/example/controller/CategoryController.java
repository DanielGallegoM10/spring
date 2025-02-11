package com.example.controller;

import com.example.repository.CategoryRepostory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepostory repostory;

    public CategoryController(CategoryRepostory repostory) {
        this.repostory = repostory;
    }

    @GetMapping
    public 



}
