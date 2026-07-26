package com.hei.todo.controller;

import com.hei.todo.dto.TodoRequest;
import com.hei.todo.dto.TodoResponse;
import com.hei.todo.model.JTodo;
import com.hei.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;
    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        TodoResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
//    @GetMapping
//    @ResponseBody
//    public String hello() {
//        return "World";
//    }

    @GetMapping
    public Page<TodoResponse> getTasksByCompletionStatus(
            @RequestParam boolean completed,
            Pageable pageable) {
        return service.getTasksByCompletionStatus(completed, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> findById(@PathVariable UUID id) {
        TodoResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<TodoResponse> update(@RequestBody TodoRequest request) {
        TodoResponse response = service.update(request);
        return ResponseEntity.ok(response);
    }

}
