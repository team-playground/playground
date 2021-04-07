package com.playground.user.domain;

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

    public void visible() {
        this.isPublic = true;
    }

    public void hide() {
        this.isPublic = false;
    }
}
