package br.com.maquininha.cartao.maquininha.cartao.exceptions;

import java.util.List;

public class MensagemDeErro {
    private int statusCode;
    private List<Erro> erros;

    public MensagemDeErro(int statusCode, List<Erro> erros) {
        this.statusCode = statusCode;
        this.erros = erros;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<Erro> getErros() {
        return erros;
    }

    public void setErros(List<Erro> erros) {
        this.erros = erros;
    }
}
