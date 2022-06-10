package com.example.demo;

import java.util.Date;

import com.example.demo.configuration.AppUser;
import com.example.demo.configuration.LoggedInUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@GetMapping("/secured")
	public Object secured(@LoggedInUser AppUser appUser){
		return appUser.getUser();
	}

	@GetMapping("/secured-admin")
	@PreAuthorize("hasRole('ROLE_admin')")
	public String securedAdmin(){
		return "Only admin can see  this";
	}
	
	@GetMapping("/public")
	public String pub(){
		
		return "This is public endpoint";
	}

	@GetMapping("/what-is-the-time")
	String time(){
		return new Date().toString();
	}
	
	@GetMapping("/fiap")
	String turma(){
		return "DEVOPS FIAP - VERSAO SALA 2";
		
	}
	

	@GetMapping("/Sala3")
	String sala3(){
		return "DEVOPS FIAP - Sala 3 top";
		
	}



	@GetMapping("/featureSala1")
	String turmaSala1(){
		return "DEVOPS FIAP 16 AGL - VERSAO 1.1";
		
	}

	@GetMapping("/prof")
	String prof(){
		return "DEVOPS FIAP - Feature do Prof";
		
	}	





}	
