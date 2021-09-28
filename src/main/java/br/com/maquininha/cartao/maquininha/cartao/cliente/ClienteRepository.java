package br.com.maquininha.cartao.maquininha.cartao.cliente;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, String> {

    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findById(int id);
}
