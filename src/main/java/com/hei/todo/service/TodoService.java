package com.hei.todo.service;

import com.hei.todo.dto.TodoRequest;
import com.hei.todo.dto.TodoResponse;
import com.hei.todo.entity.Todo;
import com.hei.todo.exception.IdNotFoundException;
import com.hei.todo.mapper.TodoMapper;
import com.hei.todo.model.JTodo;
import com.hei.todo.repository.TodoRepository;
import com.hei.todo.validator.TodoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


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

    public Page<TodoResponse> getTasksByCompletionStatus(boolean completed, Pageable pageable) {
        Page<JTodo> page = repository.findByCompleted(completed, pageable);
        return page.map(mapper::toResponse);
    }
    public TodoResponse findById(UUID id) {
        JTodo todo = repository.findById(id)
                .orElseThrow(() -> new IdNotFoundException("Id not found  : " + id));
        return mapper.toResponse(todo);
    }
    public TodoResponse update(TodoRequest request) {
        validator.validateTitle(request);
        UUID id = request.getId();

        boolean exists = repository.existsById(id);

        JTodo todo;

        if (exists) {
            todo = repository.findById(id)
                    .orElseThrow(() -> new IdNotFoundException("Todo introuvable avec l'id : " + id));
            todo.setTitle(request.getTitle());
            todo.setCompleted(request.getCompleted() != null ? request.getCompleted() : false);
            todo.setDescription(request.getDescription());
        } else {
            todo = mapper.toEntity(request);
        }

        JTodo saved = repository.save(todo);
        return mapper.toResponse(saved);
    }
}
