package br.com.maquininha.cartao.maquininha.cartao.jwt;

import br.com.maquininha.cartao.maquininha.cartao.cliente.Cliente;
import br.com.maquininha.cartao.maquininha.cartao.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class ClienteLoginService {
    @Autowired
    private ClienteRepository clienteRepository;

    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException{
        Optional<Cliente> clienteOptional = clienteRepository.findByEmail(username);

        clienteOptional.orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado!"));

        Cliente cliente = clienteOptional.get();
        return new ClienteLogin( cliente.getId(), cliente.getEmail(), cliente.getSenha() );
    }
}
