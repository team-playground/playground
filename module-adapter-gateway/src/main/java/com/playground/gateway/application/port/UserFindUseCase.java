package com.playground.gateway.application.port;

import com.playground.gateway.application.remote.UserDto;
import com.playground.gateway.application.remote.UserFindRequest;

public interface UserFindUseCase {
    UserDto findUser(UserFindRequest userFindRequest);
    boolean existUser(UserFindRequest userFindRequest);
}
