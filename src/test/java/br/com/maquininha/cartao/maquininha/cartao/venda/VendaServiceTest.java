package br.com.maquininha.cartao.maquininha.cartao.venda;

import br.com.maquininha.cartao.maquininha.cartao.cliente.Cliente;
import br.com.maquininha.cartao.maquininha.cartao.cliente.ClienteService;
import br.com.maquininha.cartao.maquininha.cartao.exceptions.ClienteNaoEncontradoException;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.OngoingStubbing;
import org.modelmapper.internal.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class VendaServiceTest {
    @Autowired
    private VendaService vendaService;

    @MockBean
    private VendaRepository vendaRepository;
    @MockBean
    private ClienteService clienteService;

    private Cliente cliente;


    @Test
    public void testarMetodocadastrarVenda() throws ClienteNaoEncontradoException {
        Venda venda = new Venda();
        Mockito.when( clienteService.pesquisarClientePorId( Mockito.anyInt() ) ).thenReturn( cliente );
        Mockito.when(vendaRepository.save(Mockito.any(Venda.class))).thenReturn(venda);

        Venda objetoTeste = vendaService.cadastrarVenda(1,venda);
        Assertions.assertEquals(venda, objetoTeste);
        Assertions.assertEquals( cliente, objetoTeste.getCliente() );
    }

    @Test
    public void testarBuscarVendaPorIdCaminhoPositivo(){
        Venda venda = new Venda();
        Optional<Venda> vendaOptional = Optional.of(venda);
        Mockito.when(vendaRepository.findById( Mockito.anyInt())).thenReturn(vendaOptional);

        Assertions.assertEquals( venda, vendaService.buscarVendaPorId(1));
    }

    @Test
    public void testarBuscarVendaPorIdCaminhoNegativo(){
        Optional<Venda> vendaOptional = Optional.empty();
        Mockito.when( vendaRepository.findById(Mockito.anyInt())).thenReturn(vendaOptional);

        RuntimeException exception = Assertions.assertThrows(RuntimeException.class,
                () -> {vendaService.buscarVendaPorId(1);});
        Assertions.assertTrue( exception.getMessage().equals("Venda não localizada"));
    }

    @Test
    public void testarDeletarVenda(){
        Venda venda = new Venda();
        Answer<Venda> answer = new Answer<Venda>() {
            @Override
            public Venda answer(InvocationOnMock invocation) throws Throwable {
                Venda venda1 = (Venda) invocation.getArgument( 1 );
                venda1.setId( 1 );
                return null;
            }
        };
    }

   @Test
    public void testeBuscarVenda(){
        Venda venda = new Venda();
        List<Venda> vendaList = Arrays.asList( venda );
       Mockito.when(vendaRepository.findAllByOpcao(Mockito.any(Opcao.class))).thenReturn(vendaList);

       List<Venda> objetoTeste = vendaService.buscarVenda( Opcao.CREDITO);

        MatcherAssert.assertThat( vendaList, CoreMatchers.is(objetoTeste));
    }
}

