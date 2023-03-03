package com.soliman.todo.controller.api;


import com.soliman.todo.dto.ToDoDto;
import com.soliman.todo.dto.UserDto;
import com.soliman.todo.utils.Constants;
import com.soliman.todo.dto.CategoryDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.soliman.todo.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/categories") // don't forget to add the dependencies for swagger2 (2 dependencies),
// and aldo the plugins in order to generate the documentation and do the mapping

public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create category", notes = "Create a new category", response = CategoryDto.class)
    // here we use response because we need to return a single object
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created category")
    })
    ResponseEntity<CategoryDto> createCategory(
            @ApiParam(value = "Category DTO", required = true) @RequestBody CategoryDto categoryDto);

    @PatchMapping(value = APP_ROOT + "/categories/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Category", notes = "Update the existing category", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The category updated successfully")
    })
    ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto user);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Category Details", notes = "Returns a list of all categories", responseContainer = "List<CategoryDto>")
    // here we use responseContainer because we need to return a list not a single object
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the categories")
    })
    ResponseEntity<List<CategoryDto>> getAllCategories();

    @GetMapping(value = APP_ROOT + "/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Category Details", notes = "Returns a category by id", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Category By id")
    })
    ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long id);

    @GetMapping(value = APP_ROOT + "/categories/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User Details by categoryId",
            notes = "Returns a user by category id",
            response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Categories by user id")
    })
    ResponseEntity<UserDto> getUserByCategoryId(@PathVariable("id") Long categoryId);

    @GetMapping(value = APP_ROOT + "/categories/todos/{id:.*}", produces = MediaType.APPLICATION_JSON_VALUE)
    // :.* means: at the end of the variable pattern allows it to match any string
    // 1. /categories/todos/1234
    // 2. /categories/todos/1234abc
    // 3. /categories/todos/
    // 4. /categories/todos/1/2/3
    @ApiOperation(value = "ToDo Details by Category Id", notes = "Returns the list of selected category", responseContainer = "List<ToDoDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the Todos")
    })
    ResponseEntity<List<ToDoDto>> getAllTodosByCategoryId(@PathVariable("id") Long id);

//    @GetMapping(value = APP_ROOT + "/categories/todos/today/{userId:.*}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ApiOperation(value = "List Of all categories and Todo for today" , notes = "Returns the list of todo of a selected category",responseContainer = "List<ToDoDto>")
//    @ApiResponses(value = {
//            @ApiResponse(code = 200 , message = "List of the Todos")
//    })
//    ResponseEntity<List<ToDoDto>> getAllTodosByCategoriesForToday(Long userId);


//    @GetMapping
//    ResponseEntity<CategoryDto> getCategory(Long id);

    @DeleteMapping(value = APP_ROOT + "/categories/{id}")
    @ApiOperation(value = "Category deleted", notes = "Delete selected category", response = CategoryDto.class)
    @ApiResponses(
            @ApiResponse(code = 200, message = "Category deleted")
    )
    ResponseEntity<CategoryDto> deleteCategory(@PathVariable("id") Long id);
}
