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

    public List<Todo> getAllTodosByStatus(String status) {
        if (status.isEmpty()) return todoRepository.findAll();
        return todoRepository.findAllByCompletedEquals(status.equals("complete"));

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

    public void toggleAllStatus(String newStatus) {
        todoRepository.toggleAllStatus(newStatus.equals("true"));
    }

    public void toggleStatusById(String paramId, String status) {
        todoRepository.toggleStatusById(Long.parseLong(paramId), status.equals("true"));
    }

    public void updateTodoById(String todoId, String newTitle) {
        todoRepository.updateTodoById(Long.parseLong(todoId), newTitle);
    }

    public Todo findTodoById(String todoId) {
        return todoRepository.findById(Long.parseLong(todoId));
    }

    public void deleteTodoById(String todoId) {
        todoRepository.deleteById(Long.parseLong(todoId));
    }


}
