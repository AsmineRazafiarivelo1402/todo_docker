package com.hei.todo.entity;

import lombok.*;

import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class Todo {
    private String id;
    private String title;
    private String description;
    private Boolean completed;
    private Instant createAt;
    private Instant updateAt;
}
