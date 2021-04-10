package com.playground.sandbox.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Task {
    private String id;
    private String description;
    private int progress;
    private TaskMember worker;

    public Task(String id, String description, TaskMember member) {
        this.id = id;
        this.description = description;
        worker = member;
    }

    public void updateProgress(int progress) {
        this.progress = progress;
        clampTask();
    }

    private void clampTask() {
        if (progress < 0) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }
    }

    public boolean isCompleted() {
        return progress == 100;
    }
}

