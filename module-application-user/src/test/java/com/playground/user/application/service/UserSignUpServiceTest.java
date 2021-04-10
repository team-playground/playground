package com.playground.user.application.service;

import com.playground.user.application.UserDto;
import com.playground.user.application.port.out.UserFindPort;
import com.playground.user.application.port.out.UserSignUpPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class UserSignUpServiceTest {

    @Mock
    private UserSignUpPort userSignUpPort;
    @Mock
    private UserFindPort userFindPort;

    @InjectMocks
    private UserSignUpService userSignUpService;

    @Test
    @DisplayName("이미 유저가 존재하는데 회원 가입을 하면 그냥 유저정보를 반환한다.")
    void 유저가_있는데_회원가입() {
        //given
        final UserDto userDto = UserDto.builder()
                .email("zkdlu@naver.com")
                .name("이건")
                .picture("geon.png")
                .build();

        given(userFindPort.existsUser(userDto)).willReturn(true);

        //when
        UserDto actual = userSignUpService.signUp(userDto);

        //then
        assertThat(actual).isEqualTo(userDto);
    }

    @Test
    @DisplayName("유저가 없는데 회원 가입을 하면 회원가입 후 정보를 반환한다.")
    void 유저가_없는데_회원가입() {
        //given
        final UserDto userDto = UserDto.builder()
                .email("zkdlu@naver.com")
                .name("이건")
                .picture("geon.png")
                .build();

        given(userFindPort.existsUser(userDto)).willReturn(false);
        given(userSignUpPort.signUp(userDto)).willReturn(UserDto.builder()
                .email("zkdlu@naver.com")
                .name("이건")
                .picture("geon.png")
                .build());

        //when
        UserDto actual = userSignUpService.signUp(userDto);

        //then
        assertThat(actual).isEqualTo(userDto);
    }
}