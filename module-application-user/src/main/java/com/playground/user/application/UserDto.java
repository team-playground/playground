package com.playground.user.application;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private String email;
    private String name;
    private String picture;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserDto) {
            return email.equals(((UserDto)obj).getEmail());
        }

        return false;
    }
}