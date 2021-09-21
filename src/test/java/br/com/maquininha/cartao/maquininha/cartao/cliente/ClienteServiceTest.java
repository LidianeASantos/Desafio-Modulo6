package br.com.maquininha.cartao.maquininha.cartao.cliente;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ClienteServiceTest {
    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testarMetodoSalvarClienteCaminhoPositivo(){
        Cliente cliente = new Cliente();
        Mockito.when(clienteRepository.save(Mockito.any(Cliente.class)))
                .thenReturn(cliente);
        Cliente objetoTeste = clienteService.cadastrarCliente(cliente);
        Assertions.assertEquals(cliente, objetoTeste);
    }
}
