package br.com.itau.cartoes.cartao.models;

import org.springframework.stereotype.Component;

import br.com.itau.cartoes.cartao.dtos.AtivaCartaoRequest;
import br.com.itau.cartoes.cartao.dtos.AtivaCartaoResponse;
import br.com.itau.cartoes.cartao.dtos.ConsultaCartaoPorIdResponse;
import br.com.itau.cartoes.cartao.dtos.ConsultaCartaoResponse;
import br.com.itau.cartoes.cartao.dtos.CreateCartaoRequest;
import br.com.itau.cartoes.cartao.dtos.CreateCartaoResponse;

@Component
public class CartaoMapper 
{
	public Cartao fromCreateCartaoRequestToCartao(CreateCartaoRequest createCartaoRequest)
	{
		Cartao cartao = new Cartao();
		cartao.setNumero(createCartaoRequest.getNumero());
		cartao.setClienteId(createCartaoRequest.getClienteId());

		return cartao;
	}
	
	public Cartao fromAtivaCartaoRequestToCartao(AtivaCartaoRequest ativaCartaoRequest)
	{
		Cartao cartao = new Cartao();
		cartao.setAtivo(ativaCartaoRequest.isAtivo());
		return cartao;
	}
	
	public CreateCartaoResponse toCreateCartaoResponse(Cartao cartao)
	{
		CreateCartaoResponse clienteCartaoReponse = new CreateCartaoResponse();
		clienteCartaoReponse.setId(cartao.getId());
		clienteCartaoReponse.setNumero(cartao.getNumero());
		clienteCartaoReponse.setAtivo(cartao.isAtivo());
		clienteCartaoReponse.setClienteId(cartao.getClienteId());
		return clienteCartaoReponse;
	}
	
	public AtivaCartaoResponse toAtivaCartaoResponse(Cartao cartao)
	{
		AtivaCartaoResponse ativaCartaoReponse = new AtivaCartaoResponse();
		ativaCartaoReponse.setId(cartao.getId());
		ativaCartaoReponse.setNumero(cartao.getNumero());
		ativaCartaoReponse.setAtivo(cartao.isAtivo());
		ativaCartaoReponse.setClienteId(cartao.getClienteId());
		return ativaCartaoReponse;
	}
	
	public ConsultaCartaoResponse toConsultaCartaoResponse(Cartao cartao)
	{
		ConsultaCartaoResponse consultaCartaoReponse = new ConsultaCartaoResponse();
		consultaCartaoReponse.setId(cartao.getId());
		consultaCartaoReponse.setNumero(cartao.getNumero());
		consultaCartaoReponse.setClienteId(cartao.getClienteId());
		return consultaCartaoReponse;
	}
	
	public ConsultaCartaoPorIdResponse toConsultaCartaoPorIdResponse(Cartao cartao)
	{
		ConsultaCartaoPorIdResponse consultaCartaoPorIdReponse = new ConsultaCartaoPorIdResponse();
		consultaCartaoPorIdReponse.setId(cartao.getId());
		consultaCartaoPorIdReponse.setNumero(cartao.getNumero());
		consultaCartaoPorIdReponse.setClienteId(cartao.getClienteId());
		consultaCartaoPorIdReponse.setAtivo(cartao.isAtivo());
		return consultaCartaoPorIdReponse;
	}
	
}
