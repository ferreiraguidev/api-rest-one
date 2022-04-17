package com.example.apirestone.form;

import lombok.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


@Value
public class LoginReqDto {

     String email;
     String senha;

    public UsernamePasswordAuthenticationToken converter() {
        return new UsernamePasswordAuthenticationToken(email, senha);
    }
}
