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
		return "DEVOPS FIAP - VERSAO 1.0";
		
	}

	
	@GetMapping("/feature-sala3")
	String sala3()
	{
	   return "DEVOPS FIAP - VERSAO  1.0";
	}

	@GetMapping("/gti150")
	String gti150(){
		return "DEVOPS FIAP - VERSAO GTI150(SMR)";
		
	}

	@GetMapping("/featureProf")
	String prof(){
		return "Essa e a feature do Prof";
		
	}


}	
