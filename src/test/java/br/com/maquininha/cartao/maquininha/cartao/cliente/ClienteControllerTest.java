package br.com.maquininha.cartao.maquininha.cartao.cliente;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(ClienteControllerTest.class)
public class ClienteControllerTest {
    @MockBean
    private ClienteService clienteService;

    @Autowired
    private MockMvc mockMvc;

    private ClienteDto clienteDto;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setup(){
        clienteDto = new ClienteDto();
        clienteDto.setNome("Guilherme");
        clienteDto.setEmail("guilherme@xablau.com");
        clienteDto.setEstabelecimento("Mercearia");
        clienteDto.setSenha("1234");

        objectMapper = new ObjectMapper();
    }
    @Test
    public void testarRotaCadastroClienteCaminhoPositivo() throws Exception{
        Mockito.when(clienteService.cadastrarCliente(Mockito.any(Cliente.class)))
                .thenReturn(clienteDto.converterDtoemCliente());
        String json = objectMapper.writeValueAsString(clienteDto);

        ResultActions resultadoDaRequisicao = mockMvc
                .perform(MockMvcRequestBuilders.post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.email",
                        CoreMatchers.equalTo(clienteDto.getEmail())));

        String jsonResposta = resultadoDaRequisicao.andReturn().getResponse().getContentAsString();
        Cliente cliente = objectMapper.readValue(jsonResposta, Cliente.class);
    }
}
