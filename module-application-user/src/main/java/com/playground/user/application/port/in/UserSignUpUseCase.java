package com.playground.user.application.port.in;

import com.playground.user.application.UserDto;

public interface UserSignUpUseCase {
    UserDto signUp(UserDto userDto);
}
