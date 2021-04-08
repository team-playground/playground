package com.playground.user.adapter.in.api;

import com.playground.user.application.UserDto;
import com.playground.user.application.UserFindRequest;
import com.playground.user.application.port.in.UserFindUseCase;
import com.playground.user.application.port.in.UserSignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApi {
    private final UserFindUseCase userFindUseCase;
    private final UserSignUpUseCase userSignUpUseCase;

    @GetMapping
    public UserDto hello() {
        return userFindUseCase.findUser(UserFindRequest.builder()
                .email("zkdlu159951@kakao.com")
                .build());
    }
}
