package cl.desafiolatam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.model.Show;
import cl.desafiolatam.model.User;
import cl.desafiolatam.service.ShowService;
import cl.desafiolatam.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class ControllerApiRest {
	@Autowired
	UserService	userService;
	
	@Autowired
	ShowService showService;
		
	
	@GetMapping("/users")
	@ResponseStatus(HttpStatus.OK)
	public List<User> findAllUsers(){
		return userService.listaUsers();
	}
	@GetMapping("/users/{id}")
	@ResponseStatus(HttpStatus.OK)
	public User findOne(@PathVariable Long id){
		return userService.findById(id);
	}
	
	@GetMapping("/shows")
	@ResponseStatus(HttpStatus.OK)
	public List<Show> findAllShow(){
		return showService.listaShows();
	}
	
	@GetMapping("/shows/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Show findShow(@PathVariable Long id){
		return showService.editShow(id);
	}
	
}
