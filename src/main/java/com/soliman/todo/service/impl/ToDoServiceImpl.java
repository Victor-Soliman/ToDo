package com.soliman.todo.service.impl;

import com.soliman.todo.dto.ToDoDto;
import com.soliman.todo.exeptions.EntityNotFoundException;
import com.soliman.todo.exeptions.ErrorCodes;
import com.soliman.todo.exeptions.InvalidEntityException;
import com.soliman.todo.validator.ToDoValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soliman.todo.repository.ToDoRepository;
import com.soliman.todo.service.ToDoService;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDoDto> findByCategoryId(Long id) {
        return null;
    }

    @Override
    public ToDoDto save(ToDoDto toDoDto) {
        // we make validation ,so we validate the entries
        List<String> errors = ToDoValidator.validateToDo(toDoDto);
        // if we have error -> we log them!, and throw a custom exception
        if (!errors.isEmpty()) {
            log.error("ToDo is not valid {}", toDoDto);
            throw new InvalidEntityException("ToDo is not valid {}",
                    ErrorCodes.TODO_NOT_FOUND, errors);
            // this exception will be handled(intercepted) by the handlers
        }
        // you should save an entity in the DB , but return a Dto
        return ToDoDto.fromEntity(toDoRepository.save(ToDoDto.toEntity(toDoDto)));
    }

    @Override
    public List<ToDoDto> findAll() {
        return toDoRepository.findAll().stream()
                .map(ToDoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ToDoDto getToDoById(Long id) {
        if (id == null) {
            log.error("Id is null");
        }
//        return ToDoDto.fromEntity(toDoRepository.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException(ErrorCodes.TODO_NOT_FOUND)));
        return toDoRepository.findById(id)
                .map(ToDoDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCodes.TODO_NOT_FOUND));
    }

    @Override
    public List<ToDoDto> findToDoByTitle(String title) {
        if (title == null) {
            log.error("title is null");
            return null;
        }
        return toDoRepository.findByTitle(title).stream()
                .map(ToDoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ToDoDto> findAllToDoAfter(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) {
            log.error("title is null");
            return null;
        }
        return toDoRepository.findByStartDateAfter(zonedDateTime).stream()
                .map(ToDoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ToDoDto> findAllDoneTodo(Boolean done) {
        if (done == null) {
            log.error("title is null");
            return null;
        }

        return toDoRepository.findByDone(done).stream()
                .map(ToDoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ToDoDto> findAllByCategoryId(Long id) {
        return toDoRepository.findAllByCategoryId(id).stream()
                .map(ToDoDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteToDoById(Long id) {
         toDoRepository.deleteById(id);
    }
}
