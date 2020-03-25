package com.codecool.todo.controllers;

import com.codecool.todo.entities.Todo;
import com.codecool.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {

    private final String SUCCESS = "{\"success\":true}";

    @Autowired
    private TodoService todoService;

    @PostMapping("/list")
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam(name= "todo-title") String todoTitle){
        todoService.addTodo(todoTitle);
        return SUCCESS;
    }

    @PutMapping("/todos/toggle_all")
    public String toggleAllStatus(@RequestParam(name= "toggle-all") String newStatus) {
        todoService.toggleAllStatus(newStatus.equals("true"));
        return SUCCESS;
    }

    @DeleteMapping("/todos/completed")
    public String deleteCompletedTodos(){
        todoService.deleteCompletedTodos();
        return SUCCESS;
    }
}
