package com.playground.user.application.service;

import com.playground.user.application.UserDto;
import com.playground.user.application.UserFindRequest;
import com.playground.user.application.port.in.UserFindUseCase;
import com.playground.user.application.port.out.UserFindPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserFindServiceTest {
    @InjectMocks
    private UserFindService userFindService;
    @Mock
    private UserFindPort userFindPort;

    @Test
    @DisplayName("있는 유저를 찾으면 유저 정보가 나온다.")
    void 있는유저를_찾으면_유저를_반환() {
        //given
        String email = "zkdlu@naver.com";
        UserFindRequest userFindRequest = new UserFindRequest(email);
        final UserDto expected = UserDto.builder()
                .email(email)
                .name("이건")
                .picture("geon.png")
                .build();

        given(userFindPort.findByEmail(userFindRequest.getEmail())).willReturn(Optional.of(expected));

        //when
        UserDto actual = userFindService.findUser(userFindRequest);

        //then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("없는 유저를 찾으면 NULL 반환.")
    void 없는유저를_찾으면_널값_반환() {
        //given
        String email = "zkdlu@naver.com";
        UserFindRequest userFindRequest = new UserFindRequest(email);

        given(userFindPort.findByEmail(email)).willReturn(Optional.empty());

        //when
        UserDto actual = userFindService.findUser(userFindRequest);

        //then
        assertThat(actual).isNull();
    }
}