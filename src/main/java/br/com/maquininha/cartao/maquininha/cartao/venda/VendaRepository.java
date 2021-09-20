package br.com.maquininha.cartao.maquininha.cartao.venda;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VendaRepository extends CrudRepository<Venda, Integer> {

    List<Venda> findAllByVendaOpcao(Opcao opcao);
}
