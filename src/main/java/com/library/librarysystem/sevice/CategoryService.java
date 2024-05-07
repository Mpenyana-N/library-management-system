package com.library.librarysystem.sevice;

import com.library.librarysystem.entity.Category;
import com.library.librarysystem.repository.CategoryRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        Category category;
        category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
        return category;
    }

    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    public void removeCategoryById(Long id) {
        Category category;
        category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
        categoryRepository.deleteById(category.getId());
    }
}
