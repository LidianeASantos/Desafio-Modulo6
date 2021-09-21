package br.com.maquininha.cartao.maquininha.cartao.exceptions;

public class VendaNaoLocalizadaException extends RuntimeException{

    public VendaNaoLocalizadaException(String mensagem){
        super(mensagem);
    }
}
