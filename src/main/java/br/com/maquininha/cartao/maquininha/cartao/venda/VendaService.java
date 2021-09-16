package br.com.maquininha.cartao.maquininha.cartao.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda cadastrarVenda(Venda venda){
        return vendaRepository.save( venda );
    }
}
