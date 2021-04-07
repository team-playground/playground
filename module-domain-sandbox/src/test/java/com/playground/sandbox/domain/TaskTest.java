package com.playground.sandbox.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @DisplayName(value = "태스크 진행 값 범위 고정")
    @Test
    void updateProgressTest() {
        //given
        Task task = new Task();

        //when
        //then
        task.updateProgress(-100);
        assertThat(task.getProgress()).isEqualTo(0);

        task.updateProgress(50);
        assertThat(task.getProgress()).isEqualTo(50);

        task.updateProgress(100);
        assertThat(task.getProgress()).isEqualTo(100);

        task.updateProgress(101);
        assertThat(task.getProgress()).isEqualTo(100);
    }
}