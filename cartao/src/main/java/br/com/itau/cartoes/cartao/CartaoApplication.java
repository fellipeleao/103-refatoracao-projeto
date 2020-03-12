package br.com.itau.cartoes.cartao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CartaoApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(CartaoApplication.class, args);
	}

}
