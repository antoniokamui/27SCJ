package br.com.fiap.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class HomeController {
	@RequestMapping("/") 

	
	
	public String iniciar(){
	 return "index";
	 }
}
