package br.com.maquininha.cartao.maquininha.cartao.jwt;

import br.com.maquininha.cartao.maquininha.cartao.cliente.Cliente;
import br.com.maquininha.cartao.maquininha.cartao.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteLoginService implements UserDetailsService {
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Cliente> clienteOptionalOptional = clienteRepository.findByEmail(username);

        clienteOptionalOptional.orElseThrow(() -> new UsernameNotFoundException("Cliente não encontrado"));

        Cliente cliente = clienteOptionalOptional.get();
        return new ClienteLogin(cliente.getId(), cliente.getEmail(), cliente.getSenha());
    }
}
