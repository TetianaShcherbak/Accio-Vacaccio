package com.codecool.travelhelper.login_registration_logout.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.codecool.travelhelper.user.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public class ThAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;

    public ThAuthenticationFilter(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String userEmail = request.getParameter("userEmail");
        String password = request.getParameter("password");


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userEmail, password);
        return authenticationManager.authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        User user =(User) authentication.getPrincipal();
        Long userId = userService.getUser(user.getUsername()).getId();
        userService.getLoginImpl().setCurrentUserId(userId);

        Algorithm algorithm = Algorithm.HMAC256("naszsupertajnykluczszyfrujacy".getBytes());
        String accessToken = JWT.create()
                .withSubject(userId.toString())
                .withIssuer("TripHelper")
                .withExpiresAt(new Date(System.currentTimeMillis()+10*60*1000))
                .withClaim("roles",user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(algorithm);

        String refreshToken = JWT.create()
                .withSubject(userId.toString())
                .withIssuer("TripHelper")
                .withExpiresAt(new Date(System.currentTimeMillis()+24*60*60*1000))
                .sign(algorithm);


        Map<String,String> tokens = new HashMap<>();
        tokens.put("userEmail",user.getUsername());
        tokens.put("tokenDostempowy", accessToken);
        tokens.put("tokenOdświerzający", refreshToken);
        tokens.put("userID", "12");
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),tokens);

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String,String> errors = new HashMap<>();
        errors.put("error","niedziała");
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(),errors);
    }
}