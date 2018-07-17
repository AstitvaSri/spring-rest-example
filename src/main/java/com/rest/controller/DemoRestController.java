package com.rest.controller;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.astitva.rest.entity.*;


@RestController
@RequestMapping("/api")
public class DemoRestController {
	private List<Students> theStudents;
	
	@PostConstruct //To Load the data just once, not for every request
	public void loadDataInList() {
		theStudents = new ArrayList<>();
		
		theStudents.add(new Students("Astitva","Srivastava"));
		theStudents.add(new Students("Anuj","Mishra"));
		theStudents.add(new Students("Elon","Musk"));
	}
	
	@GetMapping("/students")
	public List<Students> getStudents() {
				
		return theStudents;
	}
	
	@GetMapping("/login/{email}")//<--This variable should match with this variable
	public LoginDetails getLoginDetails(@PathVariable String email) {//<-----down here
		String name=null;
		if(email.equals("asti@gmail.com")) {
			name="Astitva";
		}
		else {
			name="Anuj";
		}
		
		LoginDetails loginDetails = new LoginDetails(email,name);
				
		return loginDetails;
	}
	
}
