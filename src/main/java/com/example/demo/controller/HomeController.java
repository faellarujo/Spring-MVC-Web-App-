package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Pedido;

import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
public class HomeController {

	@Autowired	
	private PedidoRepository pedidoRepository;

	@GetMapping(path = "/home")
	public String home(Model module) {		
		List<Pedido> pedidos = pedidoRepository.recuraTodosOsPedidos();
		module.addAttribute("pedidos", pedidos);
		return "home";
	}
}
