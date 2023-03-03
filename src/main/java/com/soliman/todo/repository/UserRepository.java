package com.soliman.todo.repository;

import com.soliman.todo.model.Category;
import com.soliman.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUsername(String username);

    // Query to ask George ,
    // for category service imp
//    @Query(value = "SELECT userId FROM Category c WHERE User.id = Category.id",nativeQuery = true)
//    @Query("SELECT c.user.id FROM Category c WHERE c.id = ?1") // JPQL without @Param as parameter
    @Query("SELECT c.user FROM Category c WHERE c.id = :categoryId")
    User findUserByCategoryId(@Param("categoryId") Long id);


}
