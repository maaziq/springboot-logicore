package jsp.springboot.config;

import java.util.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
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
	public SecurityFilterChain filterChain(HttpSecurity http, DaoAuthenticationProvider provider,
							  JwtAuthenticationConverter jwtAuthenticationConverter) throws Exception{
		
		http.csrf(csrf -> csrf.disable())
			.authenticationProvider(provider)
			
			.authorizeHttpRequests(auth ->
			auth.requestMatchers("/user/register", "/auth/login").permitAll()
				.anyRequest().authenticated())
				
			.sessionManagement(session -> session
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)
			.oauth2ResourceServer(oauth2 -> oauth2
					.jwt(jwt -> jwt.jwtAuthenticationConverter( jwtAuthenticationConverter))
			);
		
		return http.build();
	}
	
	
	/**
	 * Boiler plate code :–– it will be same for every project ––>
	 * @param secret
	 * @return
	 */
	@Bean
	public SecretKey jwtSecretKey(
			@org.springframework.beans.factory.annotation.Value("${jwt.secret}") String secret
			) {
		byte[] decodedKey = Base64.getDecoder().decode(secret);
		return new SecretKeySpec(decodedKey, "HmacSHA256");
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(DaoAuthenticationProvider authenticationProvider) {
		
		return new ProviderManager(authenticationProvider);
	}
	
	
	@Bean 
	public JwtAuthenticationConverter jwtAuthenticationConverter() {
		
		JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
		
		grantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
		grantedAuthoritiesConverter.setAuthorityPrefix("");
		
		JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
		authenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
		
		return authenticationConverter;
		
	}
	
	
	@Bean
	public JwtEncoder jwtEncoder(SecretKey secretKey) {
		
		return NimbusJwtEncoder
				.withSecretKey(secretKey)
				.algorithm(MacAlgorithm.HS256)
				.build();
	}
	
	
	@Bean
	public JwtDecoder jwtDecoder(SecretKey secretKey, @Value("maaz-api") String issuer) {
	
		NimbusJwtDecoder decoder = NimbusJwtDecoder
				.withSecretKey(secretKey)
				.macAlgorithm(MacAlgorithm.HS256)
				.build();
		
		decoder.setJwtValidator(JwtValidators.createDefaultWithIssuer(issuer));
		
		return decoder;
	}
}








