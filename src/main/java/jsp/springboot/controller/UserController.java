package jsp.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.dto.UserRegisterRequestDto;
import jsp.springboot.dto.UserRegisterResponseDto;
import jsp.springboot.service.AuthService;

@RestController
@RequestMapping("/user")
public class UserController {

	private AuthService authService;
	
	public UserController(AuthService authService) {
		this.authService=authService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserRegisterResponseDto> register(@RequestBody UserRegisterRequestDto requestDto ){
		
		UserRegisterResponseDto dto = authService.register(requestDto);
		
		return ResponseEntity.ok(dto);
	}
}
