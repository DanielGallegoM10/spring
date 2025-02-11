package com.example.controller;

import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repository.CategoryRepostory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}/view")
    public String getCategory(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        Optional<Category> category = repostory.findById(id);

        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "category-view"; // Nombre del archivo HTML en templates
        } else {
            redirectAttributes.addFlashAttribute("message", "Categoria no encontrada");
            redirectAttributes.addFlashAttribute("alert", "warning");
            return "redirect:/categories";
        }
    }

    @GetMapping("/{id}/edit")
    public String editCategory(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        Optional<Category> category = repostory.findById(id);

        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "category-edit"; // Nombre del archivo HTML en templates
        } else {
            redirectAttributes.addFlashAttribute("message", "Categoria no encontrada");
            redirectAttributes.addFlashAttribute("alert", "warning");
            return "redirect:/categories";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        Optional<Category> category = repostory.findById(id);

        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "category-delete"; // Nombre del archivo HTML en templates
        } else {
            redirectAttributes.addFlashAttribute("message", "Categoria no encontrada");
            redirectAttributes.addFlashAttribute("alert", "warning");
            return "redirect:/categories";
        }
    }

    @GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, Model model){

        List<Category> categories = this.repostory.findCategoriesByDescription(keyword);
        model.addAttribute("categories", categories);
        return "category-search";
    }
    


}
