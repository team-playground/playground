package com.playground.team.domain;

import com.playground.sandbox.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TeamMember {
    private String id;
    private String email;
    private String name;
    private String picture;

    @Builder
    public TeamMember(String id, String email, String name, String picture) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.picture = picture;
    }
}
