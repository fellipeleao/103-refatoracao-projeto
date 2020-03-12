package br.com.itau.cartoes.pagamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.itau.cartoes.pagamento.clients.CartaoClient;
import br.com.itau.cartoes.pagamento.dtos.ConsultaCartaoPorIdResponse;
import br.com.itau.cartoes.pagamento.exceptions.CartaoNaoAtivoException;
import br.com.itau.cartoes.pagamento.exceptions.CartaoNotFoundException;
import br.com.itau.cartoes.pagamento.models.Pagamento;
import br.com.itau.cartoes.pagamento.repositories.PagamentoRepository;
import feign.FeignException;

@Service
public class PagamentoService 
{
	@Autowired
	PagamentoRepository pagamentoRepository;
	
	@Autowired
	CartaoClient cartaoClient;
	
	public Pagamento salvaPagamento(Pagamento pagamento)
	{
		ConsultaCartaoPorIdResponse cartao = null;
        
		try 
        {
        	cartao = cartaoClient.consultaCartaoPorId(pagamento.getCartaoId());
        } 
        catch (FeignException.FeignClientException.NotFound e) 
        {
            throw new CartaoNotFoundException();
        }
		
        if(cartao == null)
        {
        	throw new CartaoNotFoundException();
        }

    	if(!cartao.isAtivo())
    	{
    		throw new CartaoNaoAtivoException();
    	}
    	
		return pagamentoRepository.save(pagamento);
	}
	
	public List<Pagamento> consultaPagamentos(int cartaoId)
	{  
        try 
        {
        	cartaoClient.consultaCartaoPorId(cartaoId);
        } 
        catch (FeignException.FeignClientException.NotFound e) 
        {
            throw new CartaoNotFoundException();
        }
		
	    List<Pagamento> listaPagamentos = pagamentoRepository.findPagamentoByCartaoId(cartaoId);
        return listaPagamentos;
	}
	
}
