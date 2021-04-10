package com.playground.gateway.adapter.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.common.application.Token;
import com.playground.common.application.port.TokenProvider;
import com.playground.gateway.application.port.UserFindUseCase;
import com.playground.gateway.application.port.UserSignUpUseCase;
import com.playground.gateway.application.remote.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {
    private final UserSignUpUseCase userSignUpUseCase;
    private final UserFindUseCase userExistsUserCase;
    private final TokenProvider tokenProvider;
    private final UserRequestMapper userRequestMapper;
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
        UserDto userDto = userRequestMapper.toDto(oAuth2User);

        if (!userExistsUserCase.existUser(userRequestMapper.toFindDto(userDto))) {
            userSignUpUseCase.signUp(userDto);
        }

        Token token = tokenProvider.generateToken(userDto.getEmail(), "USER");
        log.info("{}", token);

        response.setContentType("text/html;charset=UTF-8");
        var writer = response.getWriter();

        writer.println("<script>setTimeout(function() {");
        writer.println("window.ReactNativeWebView.postMessage('" + objectMapper.writeValueAsString(token) + "');");
        writer.println("}, 500);");
        writer.println("</script>");
        writer.flush();
    }
}
