package br.com.itau.cartoes.cliente.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.itau.cartoes.cliente.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>
{

}

