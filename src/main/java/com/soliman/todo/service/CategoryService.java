package com.soliman.todo.service;

import com.soliman.todo.dto.CategoryDto;
import com.soliman.todo.dto.ToDoDto;
import com.soliman.todo.dto.UserDto;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);
    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
//    List<CategoryDto> findAllByUserId(Long id);

    void delete(Long id);
//    List<ToDoDto> getAllTodosByCategoriesForToday(Long userId);

    // ??
//    CategoryDto findCategoryById(Long id);

    // from user controller
    UserDto getUserByCategoryId(Long id);

    List<ToDoDto> findAllToDosByCategoryId(Long categoryId);

    List<CategoryDto> findAllCategoriesByUserId(Long id);
}
