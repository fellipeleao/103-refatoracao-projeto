package br.com.itau.cartoes.pagamento.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.itau.cartoes.pagamento.dtos.ConsultaCartaoPorIdResponse;

@FeignClient(name = "cartao")
public interface CartaoClient 
{
    @GetMapping("/cartao/id/{cartaoId}")
    ConsultaCartaoPorIdResponse consultaCartaoPorId(@PathVariable(value="cartaoId") int cartaoId);
}
