package br.com.maquininha.cartao.maquininha.cartao.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class VendaServiceTest {
    @Autowired
    private VendaService vendaService;

    @MockBean
    private VendaRepository vendaRepository;
}

