package com.playground.sandbox.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TaskMember {
    private String id;
    private String email;

    @Builder
    public TaskMember(String id, String email) {
        this.id = id;
        this.email = email;
    }
}

