package com.hei.todo.service;

import com.hei.todo.dto.TodoRequest;
import com.hei.todo.dto.TodoResponse;
import com.hei.todo.entity.Todo;
import com.hei.todo.mapper.TodoMapper;
import com.hei.todo.model.JTodo;
import com.hei.todo.repository.TodoRepository;
import com.hei.todo.validator.TodoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;
    private final TodoValidator validator;
    private final TodoMapper mapper;

    public TodoResponse create(TodoRequest request){
        validator.validateTitle(request);
        JTodo todo = mapper.toEntity(request);
        JTodo saved = repository.save(todo);
        return mapper.toResponse(saved);
    }
}
