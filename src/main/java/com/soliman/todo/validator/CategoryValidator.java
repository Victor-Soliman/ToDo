package com.soliman.todo.validator;

import com.soliman.todo.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validateCategory(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        if (categoryDto == null) {
            errors.add("Please fill the name");
            errors.add("Please fill the description");
            return errors;
        }

        // here you can add any validation business rules

        // check if the name is missing
        // we use isEmpty() from StingUtils in springFramework cause is fix both cases : str == null || "".equals(str)
        if (StringUtils.isEmpty(categoryDto.getName())) {
            errors.add("Please fill the name");
        }

        // check if the description is missing
        if (StringUtils.isEmpty(categoryDto.getDescription())) {
            errors.add("Please fill the description");

        }
        return errors;
    }
}
