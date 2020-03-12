package br.com.itau.cartoes.cartao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.itau.cartoes.cartao.clients.ClienteClient;
import br.com.itau.cartoes.cartao.exceptions.CartaoNotFoundException;
import br.com.itau.cartoes.cartao.exceptions.CartaoNumberFormatException;
import br.com.itau.cartoes.cartao.exceptions.ClienteNotFoundException;
import br.com.itau.cartoes.cartao.models.Cartao;
import br.com.itau.cartoes.cartao.repositories.CartaoRepository;
import feign.FeignException;

@Service
public class CartaoService 
{
	@Autowired
	CartaoRepository cartaoRepository;
	
	@Autowired
	ClienteClient clienteClient;
	
	public Cartao salvaCartao(Cartao cartao)
	{   
        try 
        {
        	clienteClient.consultaCliente(cartao.getClienteId());
        } 
        catch (FeignException.FeignClientException.NotFound e) 
        {
            throw new ClienteNotFoundException();
        }

		return cartaoRepository.save(cartao);
	}
	
	public Cartao ativaCartao(String numero, Cartao cartaoPar)
	{
	    // Verifica número do cartao
	    try {
	        Double.parseDouble(numero);
	    } catch (NumberFormatException nfe) {
	    	throw new CartaoNumberFormatException();
	    }
	    
	    Optional<Cartao> cartao = cartaoRepository.findByNumero(numero);
	    
        if(!cartao.isPresent())
        {
        	throw new CartaoNotFoundException();
        }
        
	    cartao.get().setAtivo(cartaoPar.isAtivo());
	    
	    return cartaoRepository.save(cartao.get());
	}
	
	public Cartao consultaCartaoPorNumero(String numero)
	{
	    // Verifica número do cartao
	    try {
	        Double.parseDouble(numero);
	    } catch (NumberFormatException nfe) {
	    	throw new CartaoNumberFormatException();
	    }
	    
	    Optional<Cartao> cartao = cartaoRepository.findByNumero(numero);
	    
        if(!cartao.isPresent())
        {
        	throw new CartaoNotFoundException();
        }
        
        return cartao.get();
	}
	
	public Cartao consultaCartaoPorId(int id)
	{
	    Optional<Cartao> cartao = cartaoRepository.findById(id);
	    
        if(!cartao.isPresent())
        {
        	throw new CartaoNotFoundException();
        }
        
        return cartao.get();
	}
	
}
