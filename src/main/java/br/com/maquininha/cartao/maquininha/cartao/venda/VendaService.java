package br.com.maquininha.cartao.maquininha.cartao.venda;

import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda cadastrarVenda(Venda venda){
        return vendaRepository.save( venda );
    }

    public boolean vendaExistente(int id){
        return vendaRepository.existsById(id);
    }

    public Venda buscarVendaPorId(int id){
        Optional<Venda> optionalVenda = vendaRepository.findById(id);
        if (optionalVenda.isPresent()){
            return optionalVenda.get();
        }
        throw new RuntimeException("Venda não localizada");
    }

    public void deletarVenda(int id){
        this.vendaRepository.deleteById(id);
    }

    public List<Venda> buscarVenda(Opcao opcao){
        var taxa = opcao.taxa;
        return vendaRepository.findAllByOpcao( opcao );
    }
}
