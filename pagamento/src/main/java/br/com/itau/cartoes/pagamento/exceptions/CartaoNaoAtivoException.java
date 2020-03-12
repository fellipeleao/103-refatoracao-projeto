package br.com.itau.cartoes.pagamento.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cartão não ativo")
public class CartaoNaoAtivoException extends RuntimeException {

}
