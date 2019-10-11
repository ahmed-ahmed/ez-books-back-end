package io.ezbook.api.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.ezbook.api.model.ClientUser;
import io.ezbook.api.model.User;
import io.ezbook.api.repository.RoleRepository;
import io.ezbook.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private TenantService tenantService;
	
	private PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Transactional
    public User createUser(ClientUser user) {
		User entity = new User();
		entity.setUsername(user.getUsername());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());
		
        String encodedPassword = encoder.encode(user.getPassword());
        entity.setPassword(encodedPassword);
        String tenantId = RandomStringUtils.randomAlphabetic(10);
        entity.setTenantId(tenantId);
        entity.setRoles(Arrays.asList(roleRepository.findByRoleName("ROLE_STANDARD_USER")));
        User saved = userRepository.save(entity);
        tenantService.initDatabase(tenantId);
        return saved;
    }
}
