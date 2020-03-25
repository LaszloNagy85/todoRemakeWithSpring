package com.codecool.todo.services;

import com.codecool.todo.entities.Todo;
import com.codecool.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public void addTodo(String todoTitle) {
        Todo todo = Todo.builder()
                .title(todoTitle)
                .build();
        todoRepository.save(todo);
    }

    public void deleteCompletedTodos() {
        List<Todo> completedTodos = todoRepository.findAll().stream()
                .filter(Todo::isCompleted)
                .collect(Collectors.toList());

        todoRepository.deleteInBatch(completedTodos);
    }

    public void toggleAllStatus(Boolean newStatus) {
        todoRepository.toggleAllStatus(newStatus);
    }
}
