package com.hei.todo.mapper;

import com.hei.todo.dto.TodoRequest;
import com.hei.todo.dto.TodoResponse;
import com.hei.todo.entity.Todo;
import com.hei.todo.model.JTodo;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {
    public TodoResponse toResponse(JTodo todo){
        TodoResponse response = new TodoResponse();
        response.setId(todo.getId());
        response.setCompleted(todo.getCompleted());
        response.setDescription(todo.getDescription());
        response.setTitle(todo.getTitle());
        response.setCreatedAt(todo.getCreatedAt());
        response.setUpdateAt(todo.getUpdateAt());
        return response;
    }

    public JTodo toEntity(TodoRequest request){
        return JTodo.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .completed(request.getCompleted() != null ? request.getCompleted() : false)
                .build();
    }
}