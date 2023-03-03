package com.soliman.todo.controller;

import com.soliman.todo.controller.api.CategoryApi;

import com.soliman.todo.dto.CategoryDto;
import com.soliman.todo.dto.ToDoDto;
import com.soliman.todo.dto.UserDto;
import com.soliman.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.soliman.todo.service.CategoryService;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController implements CategoryApi {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private CategoryService categoryService;


    @Override
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(CategoryDto user) {
        return new ResponseEntity<>(categoryService.save(user), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> getCategoryById(Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> getUserByCategoryId(Long categoryId) {
        return new ResponseEntity<>(categoryService.getUserByCategoryId(categoryId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ToDoDto>> getAllTodosByCategoryId(Long categoryId) {
        return new ResponseEntity<>(categoryService.findAllToDosByCategoryId(categoryId), HttpStatus.OK);
    }


//    @Override
//    public ResponseEntity<List<ToDoDto>> getAllTodosByCategoriesForToday(Long userId) {
//        return new ResponseEntity<>(categoryService.getAllTodosByCategoriesForToday(userId), HttpStatus.OK);
//    }



//    @Override
//    public ResponseEntity<CategoryDto> getCategory(Long id) {
//        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
//    }

    @Override
    public ResponseEntity<CategoryDto> deleteCategory(Long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
