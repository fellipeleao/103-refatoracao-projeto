package br.com.itau.cartoes.cliente.models;

import org.springframework.stereotype.Component;

import br.com.itau.cartoes.cliente.dtos.ConsultaClienteResponse;
import br.com.itau.cartoes.cliente.dtos.CreateClienteRequest;
import br.com.itau.cartoes.cliente.dtos.CreateClienteResponse;

@Component
public class ClienteMapper 
{
	public Cliente toCliente(CreateClienteRequest createClienteRequest)
	{
		Cliente cliente = new Cliente();
		cliente.setName(createClienteRequest.getName());
		return cliente;
	}
	
	public CreateClienteResponse toCreateClienteResponse(Cliente cliente)
	{
		CreateClienteResponse clienteCreateReponse = new CreateClienteResponse();
		clienteCreateReponse.setId(cliente.getId());
		clienteCreateReponse.setName(cliente.getName());
		return clienteCreateReponse;
	}
	
	public ConsultaClienteResponse toConsultaClienteResponse(Cliente cliente)
	{
		ConsultaClienteResponse clienteConsultaReponse = new ConsultaClienteResponse();
		clienteConsultaReponse.setId(cliente.getId());
		clienteConsultaReponse.setName(cliente.getName());
		return clienteConsultaReponse;
	}
}
