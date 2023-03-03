package com.soliman.todo.service.impl;

import com.soliman.todo.dto.UserDto;
import com.soliman.todo.exeptions.EntityNotFoundException;
import com.soliman.todo.exeptions.ErrorCodes;
import com.soliman.todo.exeptions.InvalidEntityException;
import com.soliman.todo.repository.UserRepository;
import com.soliman.todo.service.UserService;
import com.soliman.todo.validator.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        // we make validation ,so we validate the entries
        List<String> errors = UserValidator.validateUser(userDto);
        // if we have error -> we log them!, and throw a custom exception
        if (!errors.isEmpty()) {
            log.error("User is not Valid {}", userDto);
            throw new InvalidEntityException("User is not Valid", ErrorCodes.USER_NOT_VALID, errors);
            // this exception will be handled(intercepted) by the handlers
        }
        return UserDto.fromEntity(userRepository.save(UserDto.toEntity(userDto)));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        if (id == null) {
            log.error("User Id is null");
            return null;
        }

        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<UserDto> findByUsername(String username) {
        if (username == null) {
            log.error("username is null");
            return null;
        }
        return userRepository.findByUsername(username).stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Category id is null");
        }
        userRepository.deleteById(id);
    }
}
