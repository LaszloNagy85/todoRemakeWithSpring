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

    @GetMapping("/todos/{id}")
    public Todo findTodoById(@PathVariable(value= "id") String todoId){
        return todoService.findTodoById(todoId);
    }

    @PostMapping("/list")
    public List<Todo> getAllTodos(@RequestParam(name= "status") String status){
        return todoService.getAllTodosByStatus(status);
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam(name= "todo-title") String todoTitle){
        todoService.addTodo(todoTitle);
        return SUCCESS;
    }

    @PutMapping("/todos/toggle_all")
    public String toggleAllStatus(@RequestParam(name= "toggle-all") String newStatus) {
        todoService.toggleAllStatus(newStatus);
        return SUCCESS;
    }

    @PutMapping("/todos/{id}/toggle_status")
    public String toggleStatusById(@PathVariable(value = "id") String paramId,
                                   @RequestParam(name= "status") String status) {
        todoService.toggleStatusById(paramId, status);
        return SUCCESS;
    }

    @PutMapping("/todos/{id}")
    public String updateTodoById(@PathVariable( value = "id") String todoId,
                                 @RequestParam( name = "todo-title") String newTitle){
        todoService.updateTodoById(todoId, newTitle);
        return SUCCESS;
    }

    @DeleteMapping("/todos/completed")
    public String deleteCompletedTodos(){
        todoService.deleteCompletedTodos();
        return SUCCESS;
    }

    @DeleteMapping("/todos/{id}")
    public String deleteTodoById(@PathVariable(value = "id") String todoId) {
        todoService.deleteTodoById(todoId);
        return SUCCESS;
    }






}
