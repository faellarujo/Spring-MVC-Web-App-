package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Pedido;
import com.example.demo.model.StatusPedido;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired	
	private PedidoRepository pedidoRepository;

	
	
	@GetMapping
	public String home(Model module) {		
		List<Pedido> pedidos = pedidoRepository.findAll();
		module.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	@GetMapping("/aguardando")
	public String aguardando(Model module) {		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO);
		module.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	@GetMapping("/aprovado")
	public String aprovado(Model module) {		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.APROVADO);
		module.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	@GetMapping("/entregue")
	public String entregue(Model module) {		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE);
		module.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	
	
	/*@GetMapping("/status")
	public String aguardando(@PathVariable("status") String status, Model module) {		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		module.addAttribute("pedidos", pedidos);
		return "home";
	}*/
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "home";
	}
}
