package com.kenny.wenny.todo.todo.repository;

import com.kenny.wenny.todo.todo.model.database.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
