package com.codecool.todo.repositories;

import com.codecool.todo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Query("UPDATE Todo t SET t.completed = :newStatus")
    @Modifying
    @Transactional
    void toggleAllStatus(Boolean newStatus);

    @Query("UPDATE Todo t SET t.completed = :status WHERE t.id = :paramId")
    @Modifying
    @Transactional
    void toggleStatusById(long paramId, Boolean status);

    @Query("UPDATE Todo t SET t.title = :newTitle WHERE t.id = :todoId")
    @Modifying
    @Transactional
    void updateTodoById(long todoId, String newTitle);

    Todo findById(long todoId);

    void deleteById(long todoId);

    List<Todo> findAllByCompletedEquals(Boolean status);
}
