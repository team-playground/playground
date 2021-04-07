package com.playground.team.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Team {
    private String id;
    private String name;
    private String color;
    private String banner;
    private String icon;
    private TeamMember owner;
    private List<String> tags = new ArrayList<>();
    private List<TeamMember> members = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();
    private boolean isPublic;

    @Builder
    public Team(String id, String name, String color, String banner, String icon, TeamMember owner) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.banner = banner;
        this.icon = icon;
        this.owner = owner;
    }

    public void join(TeamMember teamMember) {
        members.add(teamMember);
    }

    public void makeGroup(Group group) {
        groups.add(group);
    }

    public void visible() {
        isPublic = true;
    }

    public void hide() {
        isPublic = false;
    }
}
