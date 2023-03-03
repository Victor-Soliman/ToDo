package com.soliman.todo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.soliman.todo.model.Category;
import com.soliman.todo.model.ToDo;
import com.soliman.todo.model.User;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CategoryDto {
    private Long id;

    private String name;

    private String description;

    private User user;

    @JsonIgnore  // we use this annotation ,so we don't expose the list
    private List<ToDo> todo;

    public static Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .user(categoryDto.getUser())
                .todo(categoryDto.todo)
                .build();
    }

    public static CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .user(category.getUser())
                .todo(category.getTodo())
                .build();
    }
}
