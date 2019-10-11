package io.ezbook.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.ezbook.api.model.ClientUser;
import io.ezbook.api.service.UserService;

@Controller
@RequestMapping("/users")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(path = "register")
    public ResponseEntity<ClientUser> register(@RequestBody ClientUser user) {
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
	
}
