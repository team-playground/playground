package com.playground.common.application.port;

import com.playground.common.application.Token;

public interface TokenProvider {
    Token generateToken(String uid, String role);
    boolean verifyToken(String token);
    String getUid(String token);
}
