package com.Application.AuthService.Security;

import com.Application.AuthService.Entity.Role;
import com.Application.AuthService.Service.BlacklistService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private JwtUtil jwtUtil;
    private final BlacklistService blacklistService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token =jwtUtil.extractToken(request);
        if (token != null){
            if(blacklistService.isBlacklisted(token)){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Token is Blacklisted");
                return;
            }
        }
            if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                Claims claims = jwtUtil.extractAllClaims(token);
                Role role = Role.valueOf("ROLE_" + claims.get("role", String.class));


                List<SimpleGrantedAuthority> simpleGrantedAuthorities = new java.util.ArrayList<>(List.of(new SimpleGrantedAuthority(role.name())));

                role.getPermissions().forEach(permissions -> {
                    simpleGrantedAuthorities.add(new SimpleGrantedAuthority(permissions.name()));
                });
                if (jwtUtil.isTokenValid(token, claims.getSubject()) && !jwtUtil.isTokenExpired(token)) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken
                                    (claims.getSubject(), null, simpleGrantedAuthorities);
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                }
            }
        filterChain.doFilter(request, response);
    }
}