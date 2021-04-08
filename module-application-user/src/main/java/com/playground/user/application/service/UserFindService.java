package com.playground.user.application.service;

import com.playground.user.application.UserDto;
import com.playground.user.application.UserFindRequest;
import com.playground.user.application.port.in.UserFindUseCase;
import com.playground.user.application.port.out.UserFindPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserFindService implements UserFindUseCase {
    private final UserFindPort userFindPort;

    @Override
    public UserDto findUser(UserFindRequest userFindRequest) {
        return userFindPort.findByEmail(userFindRequest.getEmail())
                .orElse(null);
    }
}
