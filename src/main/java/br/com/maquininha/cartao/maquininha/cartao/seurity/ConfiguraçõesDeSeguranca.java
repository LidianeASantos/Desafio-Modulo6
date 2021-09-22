package br.com.maquininha.cartao.maquininha.cartao.seurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ConfiguraçõesDeSeguranca extends WebSecurityConfigurerAdapter {

}
