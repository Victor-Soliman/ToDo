package com.soliman.todo.validator;

import com.soliman.todo.dto.UserDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> validateUser(UserDto userDto) {
        List<String> errors = new ArrayList<>();

        if (userDto == null) {
            errors.add("username not found");
            errors.add("email not found");
            errors.add("password not found");
            return errors;
        }

        // here you can add any validation business rules

        // check if the name is missing
        // we use isEmpty() from StingUtils in springFramework cause is fix both cases : str == null || "".equals(str)
        if (StringUtils.isEmpty(userDto.getUsername())) {
            errors.add("Please fill the username");
        }
        if (StringUtils.isEmpty(userDto.getEmail())) {
            errors.add("Please fill the email");
        }
        if (StringUtils.isEmpty(userDto.getPassword())) {
            errors.add("Please fill the password");
        }

        return errors;
    }
}
