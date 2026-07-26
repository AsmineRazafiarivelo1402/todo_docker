package com.hei.todo.controller;

import com.hei.todo.dto.TodoRequest;
import com.hei.todo.dto.TodoResponse;
import com.hei.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
