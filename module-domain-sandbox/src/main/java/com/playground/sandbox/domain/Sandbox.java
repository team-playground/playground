package com.playground.sandbox.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Sandbox {
    private String id;
    private String description;
    private Milestone milestone;

    @Builder
    public Sandbox(String id, String description, Milestone milestone) {
        this.id = id;
        this.description = description;
        this.milestone = milestone;
    }
}
