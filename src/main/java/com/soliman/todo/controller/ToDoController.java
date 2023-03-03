package com.soliman.todo.controller;

import com.soliman.todo.controller.api.ToDoApi;
import com.soliman.todo.dto.ToDoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.soliman.todo.service.ToDoService;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class ToDoController implements ToDoApi {

    @Autowired
    private ToDoService toDoService;

    @Override
    public ToDoDto getCategoryById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ToDoDto> createToDO(ToDoDto toDoDto) {
        return new ResponseEntity<>(toDoService.save(toDoDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ToDoDto> updateToDo(ToDoDto toDoDto) {
        return new ResponseEntity<>(toDoService.save(toDoDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ToDoDto>> getAllToDo() {
        return new ResponseEntity<>(toDoService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ToDoDto> getToDoById(Long id) {
        return new ResponseEntity<>(toDoService.getToDoById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ToDoDto>> getToDoByTitle(String title) {
        return new ResponseEntity<>(toDoService.findToDoByTitle(title),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ToDoDto>> getAllToDoAfterStartDate(ZonedDateTime zonedDateTime) {
        return new ResponseEntity<>(toDoService.findAllToDoAfter(zonedDateTime),HttpStatus.OK);
    }

    @Override // ??
    public ResponseEntity<List<ToDoDto>> getAllDoneToDo(Boolean done) {
        return new ResponseEntity<>(toDoService.findAllDoneTodo(done),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ToDoDto>> getAllToDoByCategoryId(Long id) {
        return new ResponseEntity<>(toDoService.findAllByCategoryId(id),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ToDoDto> deleteTodo(Long id) {
        toDoService.deleteToDoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
