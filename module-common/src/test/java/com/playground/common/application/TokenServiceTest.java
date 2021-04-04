package com.playground.common.application;

import com.playground.common.application.port.TokenProvider;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TokenServiceTest {
    private TokenProvider tokenProvider;

    @BeforeEach
    void setUp() {
        tokenProvider = new TokenService();
    }

    @Order(1)
    @Test
    void generateToken() {
        //given
        String uid = "test";
        String role = "USER";

        //when
        Token token = tokenProvider.generateToken(uid, role);

        //then
        assertThat(token.getToken()).isNotEmpty();
        assertThat(token.getRefreshToken()).isNotEmpty();
    }

    @Order(2)
    @Test
    void verifyToken() {
        //given
        String uid = "test";
        String role = "USER";

        //when
        Token token = tokenProvider.generateToken(uid, role);

        //then
        assertThat(tokenProvider.verifyToken(token.getToken())).isTrue();
    }

    @Order(3)
    @Test
    void getUid() {
        //given
        String uid = "test";
        String role = "USER";

        //when
        Token token = tokenProvider.generateToken(uid, role);

        //then
        assertThat(tokenProvider.getUid(token.getToken())).isEqualTo("test");
    }
}