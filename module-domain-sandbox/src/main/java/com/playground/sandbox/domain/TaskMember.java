package com.playground.sandbox.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class TaskMember {
    private String id;
    private String email;

    public TaskMember(String email) {
        this.email = email;
    }
}

