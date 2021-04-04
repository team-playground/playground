package com.playground.sandbox.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MilestoneTest {
    @Test
    public void issueTaskTest() {
        //given
        Milestone milestone = new Milestone();
        TaskMember member = new TaskMember("zkdlu159951@gmail.com");

        //when
        Task task = milestone.issueTask("새 작업", member);

        //then
        assertThat(task.getWorker()).isEqualTo(member);
    }
}