package com.playground.user.application.port.in;

import com.playground.user.application.UserDto;
import com.playground.user.application.UserFindRequest;

public interface UserFindUseCase {
    UserDto findUser(UserFindRequest userFindRequest);
}
