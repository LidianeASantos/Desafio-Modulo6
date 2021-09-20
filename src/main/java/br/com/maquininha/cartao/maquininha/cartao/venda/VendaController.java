package br.com.maquininha.cartao.maquininha.cartao.venda;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/{credito}")
    @ResponseStatus(HttpStatus.CREATED)
    public VendaCreditoDto cadastrarVenda(@RequestBody @Valid Venda venda, @PathVariable String credito){
        Venda vendaModel = vendaService.cadastrarVenda( venda );

        return modelMapper.map( vendaModel, VendaCreditoDto.class );
    }
}
