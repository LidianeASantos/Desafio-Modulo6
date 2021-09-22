package br.com.maquininha.cartao.maquininha.cartao.venda;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(VendaController.class)
public class VendaControllerTest {
    @MockBean
    private  VendaService vendaService;

    @Autowired
    private MockMvc mockMvc;

    private VendaDto vendaDto;
    private ObjectMapper objectMapper;
}
