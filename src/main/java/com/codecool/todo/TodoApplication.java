package com.codecool.todo;

import com.codecool.todo.entities.Todo;
import com.codecool.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
public class TodoApplication {

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }


    @Bean
    @Profile("production")
    public CommandLineRunner init() {
//        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
//        staticFiles.location("/public");
//        port(9999);

        return args -> {

            Todo todo1 = Todo.builder()
                    .title("first TODO item")
                    .build();

            Todo todo2 = Todo.builder()
                    .title("second TODO item")
                    .build();

            Todo todo3 = Todo.builder()
                    .title("thirsd TODO item")
                    .build();

            todoRepository.saveAll(Arrays.asList(todo1, todo2, todo3));
        };
    }
}
