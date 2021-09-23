package br.com.maquininha.cartao.maquininha.cartao.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTComponente {
    private String chave = "catalisa";
    private Long milissegundos = 60000l;

    public String gerarToken(String username, int idCliente){
        Date vencimento = new Date(System.currentTimeMillis()+ milissegundos);

        String token = Jwts.builder().setSubject( username ).claim( "idCliente", idCliente ).setExpiration( vencimento ).
                signWith( SignatureAlgorithm.HS512, chave.getBytes()).compact();

        return token;

    }

}
