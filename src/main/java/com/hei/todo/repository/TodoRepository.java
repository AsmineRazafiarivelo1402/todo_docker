package com.hei.todo.repository;

import com.hei.todo.model.JTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<JTodo,String> {
}
