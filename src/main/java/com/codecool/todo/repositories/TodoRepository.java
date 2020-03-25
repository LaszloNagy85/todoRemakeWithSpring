package com.codecool.todo.repositories;

import com.codecool.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("UPDATE Todo t SET t.completed = :newStatus")
    @Modifying
    @Transactional
    void toggleAllStatus(Boolean newStatus);
}
