package br.com.maquininha.cartao.maquininha.cartao.resumovenda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumoVendaService {

    @Autowired
    private ResumoVendaRepository resumoVendaRepository;
}
