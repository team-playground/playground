package com.playground.gateway.application.port;

import com.playground.gateway.application.remote.UserDto;

public interface UserSignUpUseCase {
    UserDto signUp(UserDto userSignUpRequest);
}
