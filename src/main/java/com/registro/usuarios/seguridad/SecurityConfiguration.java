package com.registro.usuarios.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.registro.usuarios.CustomLoginSucessHandler;
import com.registro.usuarios.servicio.UsuarioServicio;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private CustomLoginSucessHandler sucessHandler;

	@Autowired
	private UsuarioServicio usuarioServicio;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServicio);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
		return authConfig.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login","/registro", "/js/**", "/css/**", "/img/**").permitAll()
				.antMatchers("/Administrador/**").hasAnyAuthority("ROLE_ADMIN").antMatchers("/Cliente/**", "/index.html")
				.hasAnyAuthority("ROLE_USER").antMatchers("/Operador/**").hasAnyAuthority("ROLE_OPERADOR").anyRequest()
				.authenticated().and().csrf().disable().formLogin().loginPage("/login").successHandler(sucessHandler)
				.usernameParameter("email").passwordParameter("password").and().logout()
				.clearAuthentication(true).logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout").and().exceptionHandling().accessDeniedPage("/access-denied");
		http.authenticationProvider(authenticationProvider());
		http.headers().frameOptions().sameOrigin();

		return http.build();
	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**", "/css/**");
    }
}
