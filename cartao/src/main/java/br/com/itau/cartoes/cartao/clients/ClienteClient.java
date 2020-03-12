package br.com.itau.cartoes.cartao.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.itau.cartoes.cartao.dtos.ConsultaClienteResponse;


@FeignClient(name = "cliente")
public interface ClienteClient 
{
    @GetMapping("/cliente/{id}")
    ConsultaClienteResponse consultaCliente(@PathVariable(value="id") int id);
}
