package jsp.springboot.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jsp.springboot.dto.UserRegisterRequestDto;
import jsp.springboot.dto.UserRegisterResponseDto;
import jsp.springboot.entity.Role;
import jsp.springboot.entity.User;
import jsp.springboot.repo.RoleRepository;
import jsp.springboot.repo.UserRepository;

@Service
public class AuthService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	
	public AuthService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public UserRegisterResponseDto register(UserRegisterRequestDto requestDto) {
		
		User user = new User();
		user.setUsername(requestDto.getUsername());
		String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
		user.setPassword(encodedPassword);
		user.setEnabled(true);
		
		Role role = roleRepository.findByName("ROLE_USER").get();
		user.getRoles().add(role);
		
		userRepository.save(user);
		
		UserRegisterResponseDto responseDto = new UserRegisterResponseDto();
		
		responseDto.setUsername(user.getUsername());
		responseDto.setMessege("User Registered Successfully!!");
		
		return responseDto;
	}	
}
