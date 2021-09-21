package br.com.maquininha.cartao.maquininha.cartao.venda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
}

