package com.playground.user.adapter.in.api;

import com.playground.user.application.UserDto;
import com.playground.user.application.UserFindRequest;
import com.playground.user.application.port.in.UserFindUseCase;
import com.playground.user.application.port.in.UserSignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApi {
    private final UserFindUseCase userFindService;
    private final UserSignUpUseCase userSignUpService;

    @PostMapping("/users")
    public UserDto signUp(@RequestBody UserDto userDto) {
        return userSignUpService.signUp(userDto);
    }

    @GetMapping("/users/{email}")
    public UserDto findUser(@PathVariable String email) {
        return userFindService.findUser(new UserFindRequest(email));
    }

    @GetMapping
    public String hello() {
        return "시발";
    }
}
