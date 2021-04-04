package com.playground.adapter;

import com.playground.common.application.Token;
import com.playground.common.application.port.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {
    private final TokenProvider tokenProvider;

    @GetMapping
    public Token test() {
        return tokenProvider.generateToken("hello", "user");
    }
}
