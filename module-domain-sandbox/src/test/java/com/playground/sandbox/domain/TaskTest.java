package com.playground.sandbox.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    @DisplayName(value = "작업 진행상태 음수를 지정하면 0으로")
    void progressMinus() {
        //given
        Task task = new Task();
        //when
        //then
        task.updateProgress(-1);
        assertThat(task.getProgress()).isEqualTo(0);
    }

    @Test
    @DisplayName(value = "작업 진행상태 0-100 지정하면 그대로")
    void progressRight() {
        //given
        Task task = new Task();
        //when
        //then
        task.updateProgress(0);
        assertThat(task.getProgress()).isEqualTo(0);

        task.updateProgress(50);
        assertThat(task.getProgress()).isEqualTo(50);

        task.updateProgress(100);
        assertThat(task.getProgress()).isEqualTo(100);
    }

    @Test
    @DisplayName(value = "작업 진행상태 100이상이면 100으로")
    void progressOver() {
        //given
        Task task = new Task();
        //when
        //then
        task.updateProgress(101);
        assertThat(task.getProgress()).isEqualTo(100);
    }

    @Test
    @DisplayName(value = "작업 진행상태가 100이면 작업완료")
    void testCompleteTask() {
        //given
        Task task = new Task();
        //when
        //then
        task.updateProgress(101);
        assertThat(task.isCompleted()).isTrue();
    }
}