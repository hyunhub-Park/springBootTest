package com.zeus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity	// Spring Security 활성화.
public class SecurityConfig
{
	
	// Security 기본 제공 정책
	// 1. 화면
	// 2.
	// 3. 인가 여부에 따른 화면
	// 4. 본인이 부여한 user, pwd만 인증.
	// 5. 로그인 실패 시 인가 X.
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception
	{
		log.info("security config ...");
		// 1. csrf 토큰 비활성화
		http.csrf().disable();
		
		// 2. /board/list 인증, /board/register 인증, 인가(MEMBER)
		// URI 패턴으로 접근 제한을 설정한다.
		http.authorizeRequests().requestMatchers("/board/list").permitAll();
		http.authorizeRequests().requestMatchers("/board/register").hasRole("MEMBER");
		
		http.authorizeRequests().requestMatchers("/notice/list").permitAll();
		http.authorizeRequests().requestMatchers("/notice/register").hasRole("ADMIN");
		
		// 3. 로그인 기본폼 사용
		// 로그인 성공시
		http.formLogin();

		// 4. id, password 기존것을 사용하는 것이 아닌, 설계자가 설계한 id, pw를 사용. 인가정책을 만들어 제시.

		// 5. id, pw가 일치하지 않는 경우
		// 접근 거부 처리자의 URI를 지정
		http.exceptionHandling().accessDeniedPage("/accessError");
		
		//폼 기반 인증기능을 사용한다.
		// HTTP 보안 설정을 빌드하고 반환한다.
		return http.build(); 
	}
	
	// @EnableWebSecurity 곳에 세워야 하는 정책.
	// 추후에는 My batis 사용.(테이블)
	@Autowired
	protected void configure (AuthenticationManagerBuilder auth) throws Exception
	{
		// 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
		auth.inMemoryAuthentication().withUser("member").
		password("{noop}1234").roles("MEMBER");
		
		auth.inMemoryAuthentication().withUser("admin").
		// password("{noop}1234").roles("ADMIN", "MEMBER");
		password("{noop}1234").roles("ADMIN");
	}
}