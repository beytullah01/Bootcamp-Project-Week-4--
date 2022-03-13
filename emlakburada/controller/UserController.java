package emlakburada.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import emlakburada.model.User;
import emlakburada.service.KullaniciService;

@RestController
public class UserController {
	
	@Autowired
	private KullaniciService kullaniciService;
	
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<User>> getAllUsers(){
		
		
		return new ResponseEntity<>(kullaniciService.getAllUsers(),HttpStatus.OK);
		
	}
	
	@PostMapping(value="/users")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		
		return new ResponseEntity<>(kullaniciService.saveUser(user),HttpStatus.CREATED);
		
	}
	@GetMapping(value = "/users/{id}")
	public ResponseEntity<User> findByIdUser(@PathVariable int id){
		
		
		return new ResponseEntity<>(kullaniciService.findByIdUser(id),HttpStatus.OK);
		
	}
	
	
	@PutMapping(value = "/users")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		
		
		return new ResponseEntity<>(kullaniciService.updateUser(user),HttpStatus.OK);
		
	}
	
	@DeleteMapping(value ="/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id){
		
		
		return new ResponseEntity<>(kullaniciService.deleteUser(id),HttpStatus.OK);
		
	}
	
	
	

}
