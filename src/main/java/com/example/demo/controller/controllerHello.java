package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerHello {

	@GetMapping(path = "/hello")
	public String helloWorld(Model model) {
		model.addAttribute("nome", "mundo!!!"); 
		return "hello";
	}
}
