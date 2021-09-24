package br.com.maquininha.cartao.maquininha.cartao.cliente;

import br.com.maquininha.cartao.maquininha.cartao.venda.Venda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
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
        Answer<Cliente> answer = new Answer<Cliente>() {
            @Override
            public Cliente answer(InvocationOnMock invocation) throws Throwable {
                Cliente cliente1 = invocation.getArgument( 1 );
                cliente1.setId( 1 );
                return null;
            }
        };

    }


}
