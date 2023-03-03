package com.soliman.todo.validator;

import com.soliman.todo.dto.ToDoDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ToDoValidator {
    public static List<String> validateToDo(ToDoDto toDoDto) {

        List<String> errors = new ArrayList<>();

        if (toDoDto == null) {
            errors.add("Please fill the title");
            errors.add("Please fill the description");
            errors.add("Please fill the start date");
            return errors;
        }


        // here you can add any validation business rules

        // check if the title is missing
        // we use isEmpty() from StingUtils in springFramework cause is fix both cases : str == null || "".equals(str)
        if (StringUtils.isEmpty(toDoDto.getTitle())) {
            errors.add("Title is not found");
        }

        // check if the description is missing
        if (StringUtils.isEmpty(toDoDto.getDescription())) {
            errors.add("Description is not found");
        }

        // check if the start date is missing
        if (StringUtils.isEmpty(toDoDto.getStartDate())) {
            errors.add("StartDate is not found");
        }
        return errors;
    }
}
