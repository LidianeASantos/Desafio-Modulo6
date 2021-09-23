package br.com.maquininha.cartao.maquininha.cartao.exceptions;

public class TokenNotValidException extends RuntimeException {
    private int statusCode = 401;

    public TokenNotValidException() {
        super("Token inválido");
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}
