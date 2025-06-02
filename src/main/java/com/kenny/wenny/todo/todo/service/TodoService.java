package com.kenny.wenny.todo.todo.service;

import com.kenny.wenny.todo.todo.model.database.Todo;
import com.kenny.wenny.todo.todo.model.request.CreateTodoRequest;
import com.kenny.wenny.todo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getAll() {
        try {
            return todoRepository.findAll();
        } catch (Exception e) {
            log.error("Failed to get todos from DB", e);
            return List.of();
        }
    }

    public void create(CreateTodoRequest todo) {
        val todoObject = new Todo();
        todoObject.setItem(todo.item());
        todoRepository.save(todoObject);
    }
}
