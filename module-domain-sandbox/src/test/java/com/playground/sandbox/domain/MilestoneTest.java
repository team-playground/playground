package com.playground.sandbox.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MilestoneTest {
    @Test
    @DisplayName("마일스톤 작업의 작업자는 지정한 작업자와 같나?")
    void issueTaskTest() {
        //given
        Milestone milestone = new Milestone("mileston-id");
        TaskMember member = new TaskMember("id", "zkdlu159951@gmail.com");

        //when
        Task task = milestone.issueTask("새 작업", member);

        //then
        assertThat(task.getWorker()).isEqualTo(member);
    }
}