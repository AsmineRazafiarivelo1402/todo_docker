package com.hei.todo.dto;

import lombok.*;


import java.time.Instant;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class TodoRequest {
    private String id;
    private String title;
    private String description;
    private Boolean completed = false;
}
