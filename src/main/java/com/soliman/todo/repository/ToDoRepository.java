package com.soliman.todo.repository;

import com.soliman.todo.dto.ToDoDto;
import com.soliman.todo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByTitle(String title);

    List<ToDo> findByStartDateAfter(ZonedDateTime zonedDateTime);

    List<ToDo> findByDone(Boolean done);

    List<ToDo> findAllByCategoryId(Long categoryId);
}
