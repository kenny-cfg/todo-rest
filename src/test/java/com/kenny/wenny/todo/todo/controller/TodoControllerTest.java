package com.kenny.wenny.todo.todo.controller;

import com.kenny.wenny.todo.todo.repository.TodoRepository;
import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TodoControllerTest {
    @Autowired
    private MockMvc mvc;
    @MockitoBean
    private TodoRepository todoRepository;

    @Test
    @SneakyThrows
    void when_createTodo_then_repositoryIsCalled() {
        val rawRequest = """
                {
                    "item": "Poo bum"
                }
                """;
        val request = post("/todo").content(rawRequest).contentType(MediaType.APPLICATION_JSON);
        mvc.perform(request).andExpect(status().isOk());

        verify(todoRepository).save(any());
    }
}