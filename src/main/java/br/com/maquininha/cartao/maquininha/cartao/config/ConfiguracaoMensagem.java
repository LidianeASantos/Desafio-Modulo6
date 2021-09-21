package br.com.maquininha.cartao.maquininha.cartao.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Component
public class ConfiguracaoMensagem {

    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource fonteDaMensagem = new ReloadableResourceBundleMessageSource();
        fonteDaMensagem.setBasename("classpath:validacao");
        fonteDaMensagem.setDefaultEncoding("UTF-8");
        return fonteDaMensagem;
    }

    @Bean
    public LocalValidatorFactoryBean validatorFactoryBean(){
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
}
