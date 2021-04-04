package com.playground.sandbox.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Getter
public class Milestone {
    private String id;
    private List<Task> tasks = new ArrayList<>();

    public Milestone(String id) {
        this.id = id;
    }

    public Task issueTask(String description, TaskMember member) {
        Task task = new Task(UUID.randomUUID().toString(), description, member);
        tasks.add(task);
        return task;
    }
}