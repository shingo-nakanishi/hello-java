package com.example.customloginpage.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class HelloAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        final MyPrincipal principal = new MyPrincipal(auth.getName());
        final MyCredentials credentials = new MyCredentials();

        return new MyAuthentication(principal, credentials);
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

}
