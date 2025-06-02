package com.kenny.wenny.todo.todo.controller;

import com.kenny.wenny.todo.todo.model.request.CreateTodoRequest;
import com.kenny.wenny.todo.todo.model.database.Todo;
import com.kenny.wenny.todo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;

    @GetMapping
    public ResponseEntity<List<Todo>> getAll() {
        val todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Void> create(
            @RequestBody CreateTodoRequest todo
    ) {
        val todoObject = new Todo();
        todoObject.setItem(todo.item());
        todoRepository.save(todoObject);
        return ResponseEntity.ok().build();
    }
}
