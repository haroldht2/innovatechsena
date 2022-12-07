package com.registro.usuarios;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class CustomLoginSucessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	 @Override
	    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
	            throws IOException {
	        String targetUrl = determineTargetUrl(authentication);
	        if (response.isCommitted()) return;
	        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	        redirectStrategy.sendRedirect(request, response, targetUrl);
	    }

	    protected String determineTargetUrl(Authentication authentication) {
	        String url = "/login?error=true";
	        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	        List<String> roles = new ArrayList<String>();
	        for (GrantedAuthority a : authorities) {
	            roles.add(a.getAuthority());
	        }
	        if (roles.contains("ROLE_ADMIN")) {
	            url = "/Administrador/dashboard";
	        } else if (roles.contains("ROLE_USER")) {
	            url = "/index";
	        } else if (roles.contains("ROLE_OPERADOR")) {
	            url = "/Operador/dashboard";
	        }
	        System.out.println(url);
	        return url;
	    }
	}