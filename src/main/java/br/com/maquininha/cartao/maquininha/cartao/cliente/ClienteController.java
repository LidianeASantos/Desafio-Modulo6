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

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteDto cadastrarCliente(@RequestBody @Valid Cliente cliente){
       Cliente clienteModel = clienteService.cadastrarCliente(cliente );

        return modelMapper.map( clienteModel, ClienteDto.class );
    }
}
