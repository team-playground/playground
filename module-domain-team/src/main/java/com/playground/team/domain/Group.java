package com.playground.team.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class Group {
    private String id;
    private List<TeamMember> members = new ArrayList<>();

    public Group(String id) {
        this.id = id;
    }
}
