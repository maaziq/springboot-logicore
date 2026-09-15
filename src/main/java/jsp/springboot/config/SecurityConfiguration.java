package jsp.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jsp.springboot.service.CustomUserDetailsService;

@Configuration
public class SecurityConfiguration {

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider provider(CustomUserDetailsService customUserDetailsService, PasswordEncoder encoder) {
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(customUserDetailsService);
		authenticationProvider.setPasswordEncoder(encoder);
		
		return authenticationProvider;
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, DaoAuthenticationProvider provider) throws Exception{
		
		http.csrf(csrf -> csrf.disable())
			.authenticationProvider(provider)
			.formLogin(Customizer.withDefaults())
			.httpBasic(Customizer.withDefaults())
			.authorizeHttpRequests(auth ->
			auth.requestMatchers("/user/register").permitAll()
				.anyRequest().authenticated()
			);
		
		return http.build();
	}
}
