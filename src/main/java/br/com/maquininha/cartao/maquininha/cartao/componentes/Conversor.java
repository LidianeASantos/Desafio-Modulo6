package br.com.maquininha.cartao.maquininha.cartao.componentes;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class Conversor {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
