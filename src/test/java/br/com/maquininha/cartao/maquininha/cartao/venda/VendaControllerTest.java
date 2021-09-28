package br.com.maquininha.cartao.maquininha.cartao.venda;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(VendaController.class)
public class VendaControllerTest {
    @MockBean
    VendaService vendaService;

    @Autowired
    private MockMvc mockMvc;

    private VendaDto vendaDto;
    private VendaTotalDto vendaTotalDto;
    private ObjectMapper objectMapper;


    public void setUp(){
       vendaDto = new VendaDto();
       vendaDto.setValor( 1 );
       vendaDto.setOpcao( Opcao.DEBITO );
       vendaDto.setQtdParcela( 1 );

       objectMapper = new ObjectMapper();
    }
}
