package io.ezbook.api.service;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.ezbook.api.exception.UserAlreadyExistsException;
import io.ezbook.api.entity.ClientUser;
import io.ezbook.api.entity.User;
import io.ezbook.api.repository.RoleRepository;
import io.ezbook.api.repository.UserRepository;
import io.ezbook.api.util.SecurityConstants;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	private PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();


	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Transactional
    public User createUser(ClientUser user) {
		// Check if username already exits
		User dbUser = userRepository.findByUsername(user.getUsername());
		if (dbUser != null) {
			throw new UserAlreadyExistsException("The username already exists!");
		}
		User entity = new User();
		entity.setUsername(user.getUsername());
		entity.setFirstName(user.getFirstName());
		entity.setLastName(user.getLastName());

        String encodedPassword = encoder.encode(user.getPassword());
        entity.setPassword(encodedPassword);
        String tenantId = RandomStringUtils.randomAlphanumeric(12);
        entity.setTenantId(tenantId);
        entity.setRoles(Arrays.asList(roleRepository.findByRoleName(SecurityConstants.STANDARD_ROLE)));
        User saved = userRepository.save(entity);
        return saved;
    }
}
