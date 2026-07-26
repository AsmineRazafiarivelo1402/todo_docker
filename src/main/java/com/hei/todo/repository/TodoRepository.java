package com.hei.todo.repository;

import com.hei.todo.model.JTodo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TodoRepository extends JpaRepository<JTodo,UUID> {
    Page<JTodo> findByCompleted(boolean completed, Pageable pageable);

}
