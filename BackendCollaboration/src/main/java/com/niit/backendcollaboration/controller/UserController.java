package com.niit.backendcollaboration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.niit.backendcollaboration.DAO.UserDAO;
import com.niit.backendcollaboration.model.User;
import com.niit.backendcollaboration.model.Error;

@RestController
public class UserController {
@Autowired	
private UserDAO userDAO;


@Autowired HttpSession session;


@GetMapping("/users") //working 
public List getUsers() {
	return userDAO.list();
}

@DeleteMapping("/users/{id}") // working 
public ResponseEntity<List<User>> deleteUser(@PathVariable int id) {
	User user = userDAO.getById(id);
	if (user == null) {
		return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
	}
	userDAO.delete(id);
	return new ResponseEntity(id, HttpStatus.OK);
}


@GetMapping("/userid/{id}") // working
public ResponseEntity getUserByID(@PathVariable("id") int id) {

	User user = userDAO.getById(id);
	if (user == null) {
		return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity(user, HttpStatus.OK);
}
 
@GetMapping("/username/{name}") // working
public ResponseEntity<User> getUserByID(@PathVariable("name") String name) { // path variable is a local any thing

	User user = userDAO.getByName(name);
	return new ResponseEntity<User>(user, HttpStatus.OK);
}
//http://localhost:8081/BackendCollaboration/usermail/cc@wmail.com
@GetMapping("/usermail/{email}")  // not working - empty display
public ResponseEntity<User> getByEmail(@PathVariable("email") String email) {

	User user = userDAO.getByEmail(email);
	
	if (user == null) {
		return new ResponseEntity("No User found for email " + email, HttpStatus.NOT_FOUND);
	}

	return new ResponseEntity<User>(user, HttpStatus.OK);
}
@PostMapping("/user") // working while posting no id - create new
public ResponseEntity save(@RequestBody User user)
{
	userDAO.saveOrUpdate(user);
	return new ResponseEntity(user, HttpStatus.OK);
}
@PutMapping("/user")   // working both auto generating - put give id update
public ResponseEntity update(@RequestBody User user)
{
	userDAO.saveOrUpdate(user);
	return new ResponseEntity(user, HttpStatus.OK);
}	
// how to check
@RequestMapping(value = "/login", method = RequestMethod.POST)
public ResponseEntity<?> login(@RequestBody User user,HttpServletRequest request) {
	HttpSession session = request.getSession();
	User validUser = userDAO.login(user);
	if (validUser == null) {
		Error error = new Error(2,"Invalid credentials.. please enter valid username and password");
		return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
	} else {
		session.setAttribute("user", validUser);
		
		
		System.out.println(validUser.getEmail());
		System.out.println(validUser.getUsername());
		User user1 = (User) session.getAttribute("user"); 
		System.out.println(user1.getRole());
		System.out.println(user1.getMobile());
		return new ResponseEntity<User>(validUser, HttpStatus.OK);
	}
}
@RequestMapping(value="/logout",method=RequestMethod.PUT)
public ResponseEntity<?> logout(HttpSession session){
	User user=(User)session.getAttribute("user");
	if(user==null){
		Error error =new Error(3,"Unauthorized user.. Please Login..");  
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
	}
	else{
		//user.setOnline(false);
		userDAO.saveOrUpdate(user);
		session.removeAttribute("user");
		session.invalidate();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}


}