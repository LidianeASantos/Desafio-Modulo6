package br.com.maquininha.cartao.maquininha.cartao.cliente;

import br.com.maquininha.cartao.maquininha.cartao.exceptions.ClienteNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void cadastrarCliente(Cliente cliente){
       String ecode = bCryptPasswordEncoder.encode((cliente.getSenha()));
       cliente.setSenha(ecode);
       clienteRepository.save( cliente );

    }

    public Cliente pesquisarClientePorId(int id) throws ClienteNaoEncontradoException {
        Optional<Cliente>clienteOptional = clienteRepository.findById( id );

        if(clienteOptional.isPresent()){
            return clienteOptional.get();
        }
        throw new ClienteNaoEncontradoException("Cliente não encontrado!");

    }
}
