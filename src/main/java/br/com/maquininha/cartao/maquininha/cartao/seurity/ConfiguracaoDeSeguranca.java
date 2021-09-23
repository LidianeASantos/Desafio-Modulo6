package br.com.maquininha.cartao.maquininha.cartao.seurity;

import br.com.maquininha.cartao.maquininha.cartao.jwt.FiltroDeAutenticacaoJWT;
import br.com.maquininha.cartao.maquininha.cartao.jwt.FiltroDeAutorizacaoJWT;
import br.com.maquininha.cartao.maquininha.cartao.jwt.JWTComponente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class ConfiguracaoDeSeguranca extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JWTComponente jwtComponente;

    private static final String[] GET_PUBLICOS = {
            "/vendas/{\\d+}",
    };

    private static final String[] POST_PUBLICOS = {
            "/vendas",
            "/login"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().configurationSource(configuracaoDeCors());

        http.authorizeRequests().antMatchers( HttpMethod.POST, POST_PUBLICOS).permitAll()
                .antMatchers(HttpMethod.GET, GET_PUBLICOS).permitAll()
                .anyRequest().authenticated();
        http.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS);

        http.addFilter(new FiltroDeAutenticacaoJWT(authenticationManager(), jwtComponente));
        http.addFilter(new FiltroDeAutorizacaoJWT(authenticationManager(), jwtComponente, userDetailsService));

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( userDetailsService ).passwordEncoder( bCryptPasswordEncoder() );
    }

    @Bean
    CorsConfigurationSource configuracaoDeCors(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
