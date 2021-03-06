package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.RequisicaoNovoPedido;
import com.example.demo.model.Pedido;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("formulario")
	public String formulario() {
		return "pedido/formulario";
	}

	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPedido requisiacao, BindingResult bindingResult) {		
					
		if (bindingResult.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = new Pedido();
		pedido = requisiacao.toPedido();
		pedidoRepository.save(pedido);		
		return "redirect/home";
	}	
	
}
