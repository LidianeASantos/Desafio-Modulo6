package br.com.maquininha.cartao.maquininha.cartao.jwt;

import br.com.maquininha.cartao.maquininha.cartao.exceptions.TokenNotValidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTComponente {
    @Value("${jwt.chave}")
    private String chave;
    @Value("${jwt.milissegundos}")
    private Long milissegundos;

    public String gerarToken(String username, int idCliente){
        Date vencimento = new Date(System.currentTimeMillis()+ milissegundos);

        String token = Jwts.builder().setSubject( username ).claim( "idCliente", idCliente ).setExpiration( vencimento ).
                signWith( SignatureAlgorithm.HS512, chave.getBytes()).compact();

        return token;

    }

    public Claims getClaims(String token){
        try{
            Claims claims = Jwts.parser().setSigningKey(chave.getBytes()).parseClaimsJws(token).getBody();
            return claims;
        }catch (Exception exception){
            throw new TokenNotValidException();
        }
    }

    public boolean isTokenValid(String token){
        try{
            Claims claims = getClaims(token);
            String username = claims.getSubject();
            Date vencimento = claims.getExpiration();
            Date dataAtual = new Date(System.currentTimeMillis());

            if (username != null && vencimento != null && dataAtual.before(vencimento)){
                return true;
            }else{
                return false;
            }
        }catch (TokenNotValidException exception){
            return false;
        }
    }

}
