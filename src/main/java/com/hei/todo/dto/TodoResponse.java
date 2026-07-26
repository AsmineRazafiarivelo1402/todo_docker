package com.hei.todo.dto;

import lombok.*;

import java.time.Instant;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class TodoResponse {
    private UUID id;
    private String title;
    private String description;
    private Boolean completed;
    private Instant createdAt;
    private Instant updateAt;
}
