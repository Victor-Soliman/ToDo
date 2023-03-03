package com.soliman.todo.repository;


import com.soliman.todo.model.Category;
import com.soliman.todo.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // JPHQL Query
    // you can use normal sql syntax by adding   nativeQuery = true   as a second parameter like this

    //  to ask George about Query  . this is regarding a method in user
//    @Query(value = "SELECT * FROM Category c WHERE userId = c.id",nativeQuery = true)
//    @Query("SELECT c FROM Category c WHERE c.user.id = ?1")  // JPQL without @Param as parameter
    @Query("SELECT c FROM Category c WHERE c.user.id = :userId")
    List<Category> findCategoryByUserId(@Param("userId") Long id);

    @Query()
    List<Category> findAllByUserId(Long id);

    //    @Query(value = "SELECT categoryId FROM ToDo WHERE ToDo.id = Category.id ",nativeQuery = true)
//    @Query("SELECT t.category.id FROM ToDo t WHERE t.id = ?1") // JPQL without @Param as parameter
    @Query("SELECT t.category.id FROM ToDo t WHERE t.id = :todoId")
    Long findCategoryByToDoId(@Param("todoId") Long id);


//    @Query("")
//    List<ToDoDto> getAllToDoByCategoriesForToday(Long id
////            @Param("startDate") ZonedDateTime startDate,
////            @Param("endDate") ZonedDateTime endDate
//    );


}
