package br.com.maquininha.cartao.maquininha.cartao.exceptions;

public class AcessoNegadoException extends RuntimeException {
    private int statusCode = 403;

    public AcessoNegadoException() {
        super("Acesso negado!");
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
