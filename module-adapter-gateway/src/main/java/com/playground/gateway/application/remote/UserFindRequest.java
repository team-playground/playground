package com.playground.gateway.application.remote;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserFindRequest {
    private String email;
}
