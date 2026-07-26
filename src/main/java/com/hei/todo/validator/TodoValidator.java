package com.hei.todo.validator;

import com.hei.todo.dto.TodoRequest;
import com.hei.todo.exception.TitleNullException;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {
    public void validateTitle(TodoRequest request){
        if(request.getTitle() == null){
            throw new TitleNullException("title shouldn't null");
        }
    }
}
