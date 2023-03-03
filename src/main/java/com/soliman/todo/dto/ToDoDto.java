package com.soliman.todo.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.soliman.todo.model.Category;
import com.soliman.todo.model.ToDo;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDoDto {

    private Long id;

    private String title;

    private String description;

    private ZonedDateTime startDate;

    private Boolean done;

    private Boolean favorite;

    private Category category;

    public static ToDo toEntity(ToDoDto toDoDto) {
        final ToDo toDo = new ToDo();
        toDo.setId(toDoDto.getId());
        toDo.setTitle(toDoDto.getTitle());
        toDo.setDescription(toDoDto.getDescription());
        toDo.setStartDate(toDoDto.getStartDate());
        toDo.setDone(toDoDto.getDone());
        toDo.setFavorite(toDoDto.getFavorite());
        toDo.setCategory(toDoDto.getCategory());

        return toDo;
    }

    public static ToDoDto fromEntity(ToDo toDo) {

      return   ToDoDto.builder()
                .id(toDo.getId())
               .title(toDo.getTitle())
               .description(toDo.getDescription())
               .startDate(toDo.getStartDate())
               .done(toDo.getDone())
               .favorite(toDo.getFavorite())
               .category(toDo.getCategory())
               .build();
    }
}
