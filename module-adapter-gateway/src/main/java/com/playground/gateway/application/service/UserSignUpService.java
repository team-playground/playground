package com.playground.gateway.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.gateway.application.port.UserSignUpUseCase;
import com.playground.gateway.application.remote.UserDto;
import com.zkdlu.apiresponsespringbootstarter.core.model.SingleResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
class UserSignUpService implements UserSignUpUseCase {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${playground.user}")
    private String USER_SERVICE;

    @Override
    public UserDto signUp(UserDto userSignUpRequest) {
        SingleResult<UserDto> user = restTemplate.postForObject(USER_SERVICE, userSignUpRequest, SingleResult.class);

        return objectMapper.convertValue(user.getData(), UserDto.class);
    }
}
