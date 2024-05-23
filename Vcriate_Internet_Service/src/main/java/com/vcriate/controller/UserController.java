package com.vcriate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcriate.exception.VcriateException;
import com.vcriate.model.User;
import com.vcriate.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

	@Autowired
	private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.register(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }
    
    @GetMapping("/profile")
    public ResponseEntity<User> getUserProfile(Authentication authentication) throws VcriateException {
        String authenticatedUsername = authentication.getName();
           
        User user1 = userService.findByUsername(authenticatedUsername);
        
        User user = userService.findByname(user1.getName());
        
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    
	@GetMapping("/logIn")
	public ResponseEntity<User> logInUserHandler(Authentication auth) throws VcriateException{
		 Optional<User> opt= Optional.of(userService.findByUsername(auth.getName()));
		 if(opt.isEmpty()) throw new VcriateException("No user found") ;
		 User user = opt.get();
		 return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}


	@PutMapping("/update")
	public ResponseEntity<User> UpdateUser(Authentication auth,@RequestBody User u) {
        String authenticatedUsername = auth.getName();
        
        User user1 = userService.findByUsername(authenticatedUsername);
         
		User updateduser = userService.UpdateUser(user1.getId(),u);

		return new ResponseEntity<>(updateduser, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<String> DeleteUser(@PathVariable("userId") Long userId) {
		String deletedUser = userService.CancelUser(userId);

		return new ResponseEntity<>(deletedUser, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<User>> alluser() {
		List<User> allUser = userService.ShowAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.ACCEPTED);
	}
}
