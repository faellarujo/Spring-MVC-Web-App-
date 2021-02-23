package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.internal.EntityManagerMessageLogger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Pedido;

@Controller
public class HomeController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping(path = "/home")
	public String home(Model module) {

		
	
		Query query = entityManager.createQuery("select p from Pedido p");
		@SuppressWarnings("unchecked")
		List<Pedido> pedidos = query.getResultList(); 
		module.addAttribute("pedidos", pedidos);

		return "home";
	}
}
