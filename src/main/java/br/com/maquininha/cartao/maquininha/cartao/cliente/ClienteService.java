package br.com.maquininha.cartao.maquininha.cartao.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Cliente cadastrarCliente(Cliente cliente){
        String ecode = bCryptPasswordEncoder.encode((cliente.getSenha()));
        cliente.setSenha(ecode);
       return clienteRepository.save( cliente );

    }
}
