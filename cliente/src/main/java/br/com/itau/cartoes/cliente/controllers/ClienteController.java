package br.com.itau.cartoes.cliente.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.itau.cartoes.cliente.dtos.ConsultaClienteResponse;
import br.com.itau.cartoes.cliente.dtos.CreateClienteRequest;
import br.com.itau.cartoes.cliente.dtos.CreateClienteResponse;
import br.com.itau.cartoes.cliente.models.Cliente;
import br.com.itau.cartoes.cliente.models.ClienteMapper;
import br.com.itau.cartoes.cliente.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController 
{
	@Autowired
	ClienteService clienteService;

	@Autowired
	ClienteMapper clienteMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CreateClienteResponse criaCliente(@Valid @RequestBody CreateClienteRequest createClienteRequest)
	{
		Cliente cliente = clienteMapper.toCliente(createClienteRequest);
		cliente = clienteService.criaCliente(cliente);
		return clienteMapper.toCreateClienteResponse(cliente);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ConsultaClienteResponse consultaCliente(@PathVariable(value="id") int id)
	{
		return clienteMapper.toConsultaClienteResponse(clienteService.consultaCliente(id));
	}

}
