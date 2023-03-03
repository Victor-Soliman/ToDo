package com.soliman.todo.controller;

import com.soliman.todo.controller.api.UserApi;
import com.soliman.todo.dto.CategoryDto;
import com.soliman.todo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.soliman.todo.service.CategoryService;
import com.soliman.todo.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController implements UserApi {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
//        return ResponseEntity.ok(userService.save(userDto));  // you can do this or:
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UserDto userDto) {
        return new ResponseEntity<>(userService.save(userDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> getUserById(Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> getUserByUsername(String username) {
        return new ResponseEntity<>(userService.findByUsername(username), HttpStatus.OK);
    }

//    @Override
//    public ResponseEntity<CategoryDto> getCategoryById(Long id) {
//        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
//    }
//

    // not finished yet
    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(Long id) {
        return new ResponseEntity<>(categoryService.findAllCategoriesByUserId(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> deleteUser(Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
