package br.com.maquininha.cartao.maquininha.cartao.cliente;

import br.com.maquininha.cartao.maquininha.cartao.componentes.Conversor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarCliente(@RequestBody @Valid ClienteDto clienteDto){
       Cliente clienteModel = clienteDto.converterDtoemCliente();

        clienteService.cadastrarCliente(clienteModel);
    }
}
