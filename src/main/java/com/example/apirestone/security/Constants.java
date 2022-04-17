package com.example.apirestone.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String SECRET = "sacre";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER = "Authorization";
    public static final String LOGIN_URL = "/login";
    public static final Long EXPIRATION_TIME = 3600000L; //  1 dia

}
