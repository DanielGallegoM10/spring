package com.example.controller;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.CategoryRepostory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepostory repostory;

    public CategoryController(CategoryRepostory repostory) {
        this.repostory = repostory;
    }

    @GetMapping
    public String findAll(Model model){
        List<Category> categories = this.repostory.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }

    @GetMapping("/new")
    public String getForm(Model model){
        model.addAttribute("categories", new Category());
        return "category-form";
    }

    



}
