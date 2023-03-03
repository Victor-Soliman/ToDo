package com.soliman.todo.service;

import com.soliman.todo.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    UserDto save(UserDto userDto);

    List<UserDto> findAll();

    UserDto findById(Long id);

    List<UserDto> findByUsername(String username);

    void delete(Long id);
}
