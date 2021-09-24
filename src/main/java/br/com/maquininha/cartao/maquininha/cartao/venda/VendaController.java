package br.com.maquininha.cartao.maquininha.cartao.venda;

import br.com.maquininha.cartao.maquininha.cartao.exceptions.ClienteNaoEncontradoException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/{clienteId}")
    @ResponseStatus(HttpStatus.CREATED)
    public VendaDto cadastrarVenda(@RequestBody @Valid Venda venda, @PathVariable int clienteId) throws ClienteNaoEncontradoException {
        Venda vendaModel = vendaService.cadastrarVenda(clienteId, venda);

        return modelMapper.map(vendaModel, VendaDto.class);
    }

    @GetMapping("/{buscarVendas}")
    public Venda pesquisarVendaPorId(@PathVariable(name = "buscarVendas") int id) {
        return vendaService.buscarVendaPorId( id );

     }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPeloID(@PathVariable int id){
        vendaService.deletarVenda(id);
    }

    @GetMapping("/extrato/{opcao}")
    public List<Venda> resumoDeVendaPorOpcao(@PathVariable(name = "opcao") Opcao opcao ){
        return vendaService.buscarVenda( opcao );
    }

}
