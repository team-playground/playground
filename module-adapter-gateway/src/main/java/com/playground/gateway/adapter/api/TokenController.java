package com.playground.gateway.adapter.api;

import com.playground.common.application.Token;
import com.playground.common.application.port.TokenProvider;
import com.playground.gateway.exception.ExpireRefreshTokenException;
import com.playground.gateway.exception.ExpireTokenException;
import com.playground.gateway.exception.NotValidUserException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
public class TokenController {
    private final TokenProvider tokenProvider;
    @GetMapping("/token")
    public Token test() {
        throw new NotValidUserException();
    }

    @GetMapping("/token/auth")
    public String auth() {
        throw new ExpireTokenException();
    }

    @GetMapping("/token/refresh")
    public String refreshAuth(HttpServletRequest request, HttpServletResponse response) {
        String token = request.getHeader("Refresh");

        if (token != null && tokenProvider.verifyToken(token)) {
            String email = tokenProvider.getUid(token);
            Token newToken = tokenProvider.generateToken(email, "USER");

            response.addHeader("Auth", newToken.getToken());
            response.addHeader("Refresh", newToken.getRefreshToken());
            response.setContentType("application/json;charset=UTF-8");

            return "HAPPY NEW TOKEN";
        }

        throw new ExpireRefreshTokenException();
    }
}
