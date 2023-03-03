package com.soliman.todo.service;

import com.soliman.todo.dto.ToDoDto;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
@Service
public interface ToDoService {

    List<ToDoDto> findByCategoryId(Long id);

    ToDoDto save(ToDoDto toDoDto);


    List<ToDoDto> findAll();

    ToDoDto getToDoById(Long id);

    List<ToDoDto> findToDoByTitle(String title);

    List<ToDoDto> findAllToDoAfter(ZonedDateTime zonedDateTime);

    List<ToDoDto> findAllDoneTodo(Boolean done);

    List<ToDoDto> findAllByCategoryId(Long id);

    void deleteToDoById(Long id);
}
