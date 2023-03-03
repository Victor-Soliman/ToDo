package com.soliman.todo.controller.api;

//import com.soliman.todo.dto.CategoryDto;

import com.soliman.todo.dto.CategoryDto;
import com.soliman.todo.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.soliman.todo.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/users")// don't forget to add the dependencies for swagger2 (2 dependencies),
// and also the plugins in order to generate the documentation and do the mapping

public interface UserApi {

    @PostMapping(value = APP_ROOT + "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create user", notes = "Create a new user", response = UserDto.class)
    // here we use response because we need to return a single object
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The newly created user")
    })
    ResponseEntity<UserDto> createUser(
            @ApiParam(value = "user DTO", required = true)@RequestBody UserDto userDto);

    @PatchMapping(APP_ROOT + "/users/update")
    @ApiOperation(value = "Update User", notes = "Update the existing user", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The user updated successfully")
    })

    ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto);

    @GetMapping(value = APP_ROOT + "/users/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User Details", notes = "Returns a list of all users", responseContainer = "List<UserDto")
    // here we use responseContainer because we need to return a list not a single object
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all users")
    })
    ResponseEntity<List<UserDto>> getAllUsers();

    @GetMapping(value = APP_ROOT + "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User Details", notes = "Returns a user by id", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User By id")
    })
    ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") Long id);

    @GetMapping(value = APP_ROOT + "/users/name", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User Details", notes = "Return a list of users by username", responseContainer = "List<UserDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users by username")
    })
    ResponseEntity<List<UserDto>> getUserByUsername(String username);

//    @GetMapping // ??
//    ResponseEntity<CategoryDto> getCategoryById(Long id);

    @GetMapping(value = APP_ROOT + "/users/categories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Categories Details", notes = "List of categories by user id ", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "categories by user id")
    })
    ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(@PathVariable("id") Long userId);

    @DeleteMapping(value = APP_ROOT + "users/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User deleted",notes = "Delete the list of selected user", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200 ,message = "User deleted")
    })
    ResponseEntity<UserDto> deleteUser(@PathVariable("id") Long id);


}
