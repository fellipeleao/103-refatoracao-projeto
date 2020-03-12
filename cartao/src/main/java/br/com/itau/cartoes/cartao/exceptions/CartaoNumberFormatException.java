package br.com.itau.cartoes.cartao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Número do cartão é inválido")
public class CartaoNumberFormatException extends RuntimeException {

}
