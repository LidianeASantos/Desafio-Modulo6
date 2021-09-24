package br.com.maquininha.cartao.maquininha.cartao.venda;

import br.com.maquininha.cartao.maquininha.cartao.cliente.Cliente;
import br.com.maquininha.cartao.maquininha.cartao.cliente.ClienteService;
import br.com.maquininha.cartao.maquininha.cartao.exceptions.ClienteNaoEncontradoException;
import br.com.maquininha.cartao.maquininha.cartao.exceptions.VendaNaoLocalizadaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ClienteService clienteService;

    public Venda cadastrarVenda(int idCliente, Venda venda) throws ClienteNaoEncontradoException {
        Cliente cliente = clienteService.pesquisarClientePorId( idCliente );

        venda.setCliente(cliente);
        return vendaRepository.save( venda );
    }

   /* public boolean vendaExistente(int id){
        return vendaRepository.existsById(id);
    }*/

    public Venda buscarVendaPorId(int id){
        Optional<Venda> optionalVenda = vendaRepository.findById(id);
        if (optionalVenda.isPresent()){
            return optionalVenda.get();
        }
        throw new VendaNaoLocalizadaException("Venda não localizada");
    }

    public void deletarVenda(int id){
        this.vendaRepository.deleteById(id);
    }

    public List<Venda> buscarVenda(Opcao opcao){

        return vendaRepository.findAllByOpcao( opcao );
    }
}
