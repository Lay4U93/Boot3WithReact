package com.example.webdev101.persistence;

import com.example.webdev101.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {

    @Query("select t from TodoEntity t where t.userId = :userId")
    List<TodoEntity> findByUserIdQuery(@Param("userId") String userId);

    List<TodoEntity> findByUserId(String userId);
}
