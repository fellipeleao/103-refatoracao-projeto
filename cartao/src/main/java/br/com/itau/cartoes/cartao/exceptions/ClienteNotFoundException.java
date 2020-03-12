package br.com.itau.cartoes.cartao.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Cliente não encontrado")
public class ClienteNotFoundException extends RuntimeException {

}
