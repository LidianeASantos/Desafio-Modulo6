package br.com.maquininha.cartao.maquininha.cartao.venda;

import br.com.maquininha.cartao.maquininha.cartao.exceptions.ClienteNaoEncontradoException;
import br.com.maquininha.cartao.maquininha.cartao.jwt.JWTComponente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JWTComponente jwtComponente;

    @PostMapping("/{clienteId}")
    @ResponseStatus(HttpStatus.CREATED)
    public VendaDto cadastrarVenda(@RequestBody @Valid Venda venda, @PathVariable int clienteId) throws ClienteNaoEncontradoException {
        Venda vendaModel = vendaService.cadastrarVenda(clienteId, venda);

        return modelMapper.map(vendaModel, VendaDto.class);
    }

    @GetMapping("/{buscarVendas}")
    public Venda pesquisarVendaPorId(@PathVariable(name = "buscarVendas") int id, Authentication authentication) {
        String email = authentication.getName();
        return vendaService.buscarVendaPorId( id );

     }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPeloID(@PathVariable int id, Authentication authentication){
        String email = authentication.getName();
        vendaService.deletarVenda(id);
    }

    @GetMapping("/extrato/{opcao}")
    public List<VendaDto> resumoDeVendaPorOpcao(@PathVariable(name = "opcao") Opcao opcao, Authentication authentication ){
        String email = authentication.getName();
        List<Venda> vendalModel = vendaService.buscarVenda( opcao );
        List<VendaDto> vendaDtoList = vendalModel.stream().map( venda -> modelMapper.map( venda, VendaDto.class ) ).collect( Collectors.toList());
        return vendaDtoList;
    }

}
