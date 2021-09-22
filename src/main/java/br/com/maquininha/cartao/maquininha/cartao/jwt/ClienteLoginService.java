package br.com.maquininha.cartao.maquininha.cartao.jwt;

import br.com.maquininha.cartao.maquininha.cartao.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteLoginService {
    @Autowired
    private ClienteRepository clienteRepository;
}
