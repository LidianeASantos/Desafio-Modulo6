package br.com.maquininha.cartao.maquininha.cartao.venda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

@SpringBootTest
public class VendaServiceTest {
    @Autowired
    private VendaService vendaService;

    @MockBean
    private VendaRepository vendaRepository;

    @Test
    public void testarMetodocadastrarVenda(){
        Venda venda = new Venda();
        Mockito.when(vendaRepository.save(Mockito.any(Venda.class))).thenReturn(venda);

        Venda objetoTeste = vendaService.cadastrarVenda(venda);
        Assertions.assertEquals(venda, objetoTeste);
    }

    @Test
    public void buscarVendaPorIdCaminhoPositivo(){
        Venda venda = new Venda();
        Optional<Venda> vendaOptional = Optional.of(venda);
        Mockito.when(vendaRepository.findById( Mockito.anyInt())).thenReturn(vendaOptional);

        Assertions.assertEquals( venda, vendaService.buscarVendaPorId(1));
    }
}
