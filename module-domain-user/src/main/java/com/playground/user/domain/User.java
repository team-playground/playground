package com.playground.user.domain;

import com.playground.team.domain.Team;
import com.playground.team.domain.TeamMember;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class User {
    private String id;
    private String email;
    private String name;
    private String picture;
    private boolean isPublic;

    @Builder
    public User(String id, String email, String name, String picture) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.picture = picture;
        this.isPublic = true;
    }

    public Team makeTeam(String teamId, String banner, String icon, String teamName, String teamColor) {
        return Team.builder()
                .id(teamId).name(teamName)
                .banner(banner).icon(icon).color(teamColor)
                .owner(convertTeamMember())
                .build();
    }

    public void joinTeam(Team team) {
        team.join(convertTeamMember());
    }

    public TeamMember convertTeamMember() {
        return TeamMember.builder()
                .id(id)
                .email(email)
                .name(name)
                .picture(picture)
                .build();
    }

    public void visible() {
        this.isPublic = true;
    }

    public void hide() {
        this.isPublic = false;
    }
}
