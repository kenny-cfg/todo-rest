package com.kenny.wenny.todo.todo.service;

import com.kenny.wenny.todo.todo.model.database.Todo;
import com.kenny.wenny.todo.todo.model.request.CreateTodoRequest;
import com.kenny.wenny.todo.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    public void create(CreateTodoRequest todo) {
        val todoObject = new Todo();
        todoObject.setItem(todo.item());
        todoRepository.save(todoObject);
    }
}
