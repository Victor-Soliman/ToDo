package com.soliman.todo.service.impl;

import com.soliman.todo.dto.CategoryDto;

import com.soliman.todo.dto.ToDoDto;
import com.soliman.todo.dto.UserDto;
import com.soliman.todo.exeptions.EntityNotFoundException;
import com.soliman.todo.exeptions.ErrorCodes;
import com.soliman.todo.exeptions.InvalidEntityException;
import com.soliman.todo.repository.CategoryRepository;
import com.soliman.todo.repository.ToDoRepository;
import com.soliman.todo.repository.UserRepository;
import com.soliman.todo.service.CategoryService;
import com.soliman.todo.validator.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ToDoRepository toDoRepository;


    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        // we make validation ,so we validate the entries
        List<String> errors = CategoryValidator.validateCategory(categoryDto);
        // if we have error -> we log them!, and throw a custom exception
        if (!errors.isEmpty()) {
            log.error("Category is not valid {}", categoryDto);
            throw new InvalidEntityException("Category is not valid", ErrorCodes.CATEGORY_NOT_VALID, errors);
            // this exception will be handled(intercepted) by the handlers
        }

        // you should save an entity in the DB , but return a Dto
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(categoryDto)));
    }

    @Override
    public List<CategoryDto> findAll() {
//        List<Category> categoriesFromDB = categoryRepository.findAll();
//        return categoriesFromDB.stream()
//                .map(category -> new CategoryDto().fromEntity(category))
//                .collect(Collectors.toList());
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Long id) {
        if (id == null) {
            log.error("Category id is null");
            return null;
        }
        return categoryRepository.findById(id)
                .map(CategoryDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCodes.CATEGORY_NOT_FOUND));
    }

    // for user controller
    @Override
    public UserDto getUserByCategoryId(Long id) {
        return UserDto.fromEntity(userRepository.findUserByCategoryId(id));
    }

    @Override
    public List<ToDoDto> findAllToDosByCategoryId(Long categoryId) {
        return toDoRepository.findAllByCategoryId(categoryId).stream()
                .map(ToDoDto::fromEntity)
                .collect(Collectors.toList());
    }

    // ??
    @Override
    public List<CategoryDto> findAllCategoriesByUserId(Long id) {
        return categoryRepository.findAllById(Collections.singleton(id)).stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Category id is null");
        }
        categoryRepository.deleteById(id);
    }


    // complex query
//    @Override
//    public List<ToDoDto> getAllTodosByCategoriesForToday(Long userId) {
//        return categoryRepository.getAllToDoByCategoriesForToday(userId);
//    }

    // user repo  TO DELETE
//    @Override
//    public CategoryDto findCategoryById(Long id) {
//
//        return null;
//    }
    // user repo   TO DELETE
//    @Override
//    public List<CategoryDto> findAllCategoriesById(Long id) {
//        return null;
//    }
}
