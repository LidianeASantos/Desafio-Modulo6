package br.com.maquininha.cartao.maquininha.cartao.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(Cliente cliente){
        clienteRepository.save( cliente );
        
        return cliente;
    }
}
