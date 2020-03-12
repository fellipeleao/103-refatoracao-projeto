package br.com.itau.cartoes.pagamento.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.itau.cartoes.pagamento.dtos.ConsultaPagamentoResponse;
import br.com.itau.cartoes.pagamento.dtos.CreatePagamentoRequest;
import br.com.itau.cartoes.pagamento.dtos.CreatePagamentoResponse;

@Component
public class PagamentoMapper 
{
	public Pagamento toPagamento(CreatePagamentoRequest createPagamentoRequest)
	{
		Pagamento pagamento = new Pagamento();
		pagamento.setCartaoId(createPagamentoRequest.getCartao_id());
		pagamento.setDescricao(createPagamentoRequest.getDescricao());
		pagamento.setValor(createPagamentoRequest.getValor());
		return pagamento;
	}
	
	public CreatePagamentoResponse toCreatePagamentoResponse(Pagamento pagamento)
	{
		CreatePagamentoResponse createPagamentoResponse = new CreatePagamentoResponse();
		createPagamentoResponse.setId(pagamento.getId());
		createPagamentoResponse.setCartao_id(pagamento.getCartaoId());
		createPagamentoResponse.setDescricao(pagamento.getDescricao());
		createPagamentoResponse.setValor(pagamento.getValor());
		return createPagamentoResponse;
	}

	
	public List<ConsultaPagamentoResponse> toListConsultaPagamentoResponse(List<Pagamento> listaPagamento)
	{
		List<ConsultaPagamentoResponse> listaConsultaPagamentoResponse = new ArrayList<ConsultaPagamentoResponse>();
		
		for(Pagamento pagamento : listaPagamento)
		{
			ConsultaPagamentoResponse consultaPagamentoResponse = new ConsultaPagamentoResponse();
			consultaPagamentoResponse.setId(pagamento.getId());
			consultaPagamentoResponse.setCartao_id(pagamento.getCartaoId());
			consultaPagamentoResponse.setDescricao(pagamento.getDescricao());
			consultaPagamentoResponse.setValor(pagamento.getValor());
			listaConsultaPagamentoResponse.add(consultaPagamentoResponse);
		}

		return listaConsultaPagamentoResponse;
	}

}
