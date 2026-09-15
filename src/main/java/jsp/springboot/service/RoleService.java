package jsp.springboot.service;

import org.springframework.stereotype.Service;
import jsp.springboot.entity.Role;
import jsp.springboot.repo.RoleRepository;

@Service
public class RoleService {

	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public void addRole(Role role) {
		
		roleRepository.save(role);
	}
}
