package com.example.oauth_2._no.springsec;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Jwtfilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        String header = httpServletRequest.getHeader("authorization");

        if (httpServletRequest == null || !header.startsWith("Bearer "))
        {
            throw new ServletException("wrong or empty header");
         }
        else
        {
            try {
                String token = header.substring(7);
                //wprowadzamy hasło do odkodowania tokena i wyciągamy dane z tokena jeżeli poniższe uda się wykonać
                //uda się wykonać jak hasło się zgadza / jak hasło nieprawidłowe to rzuci komunikat ze nieprawidlowe
                //todo z jakiego powodu trochę hasło moze się róznić nie do przyjęcia error
                Claims claims = Jwts.parser().setSigningKey("passw").parseClaimsJws(token).getBody();
                servletRequest.setAttribute("claims",claims);
            }
            catch (Exception e)
            {
                throw new ServletException("wrong key");
            }
        }

        filterChain.doFilter(servletRequest,servletResponse);

    }
}
