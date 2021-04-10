package com.playground.gateway.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.playground.gateway.application.port.UserFindUseCase;
import com.playground.gateway.application.remote.UserDto;
import com.playground.gateway.application.remote.UserFindRequest;
import com.zkdlu.apiresponsespringbootstarter.core.model.SingleResult;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
class UserFindService implements UserFindUseCase {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${playground.user}")
    private String USER_SERVICE;

    @Override
    public UserDto findUser(UserFindRequest userFindRequest) {
        SingleResult<UserDto> result = restTemplate.getForObject(USER_SERVICE + userFindRequest.getEmail(), SingleResult.class);

        return objectMapper.convertValue(result.getData(), UserDto.class);
    }

    @Override
    public boolean existUser(UserFindRequest userFindRequest) {
        SingleResult<UserDto> result = restTemplate.getForObject(USER_SERVICE + userFindRequest.getEmail(), SingleResult.class);
        return result.getData() != null;
    }
}
