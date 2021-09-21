package br.com.maquininha.cartao.maquininha.cartao.exceptions;

import java.util.List;

public class MensagemDeErro {
    private int statuscode;
    private List<Erro> erros;

    public MensagemDeErro(int statuscode, List<Erro> erros) {
        this.statuscode = statuscode;
        this.erros = erros;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public List<Erro> getErros() {
        return erros;
    }

    public void setErros(List<Erro> erros) {
        this.erros = erros;
    }
}
