package com.kenny.wenny.todo.todo.service;

import com.kenny.wenny.todo.todo.model.database.Todo;
import com.kenny.wenny.todo.todo.repository.TodoRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class TodoServiceTest {
    @Autowired
    private TodoService todoService;
    @MockitoBean
    private TodoRepository todoRepository;

    @Test
    void when_repositoryReturnsObjects_then_returnsObjects() {
        when(todoRepository.findAll()).thenReturn(
                List.of(
                        new Todo(1, "first"),
                        new Todo(2, "second")
                )
        );

        val actual = todoService.getAll();

        assertEquals(2, actual.size());
    }

    @Test
    void when_repositoryThrows_then_returnEmptyList() {
        when(todoRepository.findAll()).thenThrow(RuntimeException.class);

        val actual = todoService.getAll();

        assertEquals(0, actual.size());
    }
}