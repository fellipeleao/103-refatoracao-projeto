package br.com.itau.cartoes.pagamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.itau.cartoes.pagamento.models.Pagamento;

public interface PagamentoRepository extends CrudRepository<Pagamento, Integer> 
{	
	@Query(value = "select * from pagamento where cartao_id = :cartaoId", nativeQuery = true)
	List<Pagamento> findPagamentoByCartaoId(int cartaoId);
}

