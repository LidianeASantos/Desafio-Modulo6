package br.com.maquininha.cartao.maquininha.cartao.venda;

public enum Opcao {

    DEBITO(1.5),
    CREDITO(3.5);

    public double taxa;

    Opcao(double v) {
        taxa =v;
    }

}
