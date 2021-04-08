package com.playground.user.application.service;

import com.playground.user.application.UserDto;
import com.playground.user.application.port.in.UserSignUpUseCase;
import com.playground.user.application.port.out.UserFindPort;
import com.playground.user.application.port.out.UserSignUpPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserSignUpService implements UserSignUpUseCase {
    private final UserSignUpPort userSignUpPort;
    private final UserFindPort userFindPort;

    @Override
    public UserDto signUp(UserDto userDto) {
        if (!userFindPort.existsUser(userDto)) {
            userSignUpPort.signUp(userDto);
        }

        return userDto;
    }
}
