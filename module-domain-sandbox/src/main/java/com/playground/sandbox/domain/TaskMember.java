package com.playground.sandbox.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TaskMember {
    private String id;
    private String email;

    public TaskMember(String email) {
        this.email = email;
    }

    public static TaskMember convertFrom(Member member) {
        return new TaskMember(member.getEmail());
    }
}

