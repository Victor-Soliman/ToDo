package com.soliman.todo.controller.api;

import com.soliman.todo.dto.ToDoDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

import static com.soliman.todo.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/todo")// don't forget to add the dependencies for swagger2 (2 dependencies),
// and aldo the plugins in order to generate the documentation and do the mapping

public interface ToDoApi {

    ToDoDto getCategoryById(Long id);

    @PostMapping(value = APP_ROOT + "/todo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create ToDo", notes = "Create a new ToDo", response = ToDoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The newly created ToDo")
    })
    ResponseEntity<ToDoDto> createToDO(
            @ApiParam(value = "ToDo DTO", required = true) @RequestBody ToDoDto toDoDto);

    @PatchMapping(value = APP_ROOT + "/todo/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Todo", notes = "Update the existing todo", response = ToDoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The todo updated successfully")
    })
    ResponseEntity<ToDoDto> updateToDo(@RequestBody ToDoDto toDoDto);

    @GetMapping(value = APP_ROOT + "/todo/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "ToDos Details", notes = "Returns a list of all todos", responseContainer = "List<ToDoDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all todos")
    })
    ResponseEntity<List<ToDoDto>> getAllToDo();

    @GetMapping(value = APP_ROOT + "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details", notes = "Returns a Todo by id", response = ToDoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ToDO by id")
    })
    ResponseEntity<ToDoDto> getToDoById(@PathVariable(value = "id") Long id);

    @GetMapping(value = APP_ROOT + "/todo/title", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details", notes = "Returns a Todo by title", response = ToDoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ToDO by title")
    })
    ResponseEntity<List<ToDoDto>> getToDoByTitle(
            @ApiParam(value = "name", required = true) @RequestParam(name = "title") String title);

    @GetMapping(value = APP_ROOT + "/todo/afterStartDate", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details", notes = "Returns a Todos after start date", responseContainer = "List<ToDoDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ToDOs after a start date")
    })
    ResponseEntity<List<ToDoDto>> getAllToDoAfterStartDate(ZonedDateTime zonedDateTime);

    @GetMapping(value = APP_ROOT + "/todo/done", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details", notes = "Returns a list of done Todos", responseContainer = "List<ToDoDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Done ToDos")
    })
    ResponseEntity<List<ToDoDto>> getAllDoneToDo(Boolean done);

    @GetMapping(value = APP_ROOT + "/todo/category/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details", notes = "Returns a list of Todos by category id", responseContainer = "List<ToDoDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ToDOs by category id")
    })
    ResponseEntity<List<ToDoDto>> getAllToDoByCategoryId(@PathVariable(value = "id") Long id);

    @DeleteMapping(value = APP_ROOT + "/todo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Deleted", notes = "Todo deleted by id", response = ToDoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Todo Deleted")
    })
    ResponseEntity<ToDoDto> deleteTodo(@PathVariable(value = "id") Long id);

}
