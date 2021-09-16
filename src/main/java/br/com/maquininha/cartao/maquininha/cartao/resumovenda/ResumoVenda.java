package br.com.maquininha.cartao.maquininha.cartao.resumovenda;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "resumo_vendas")
public class ResumoVenda {

    private double valorTotalVenda;
    private double valorTotalTaxa;
    private double valorTotalLiquido;

    public ResumoVenda() {
    }

    public double getValorTotalVenda() {
        return valorTotalVenda;
    }

    public void setValorTotalVenda(double valorTotalVenda) {
        this.valorTotalVenda = valorTotalVenda;
    }

    public double getValorTotalTaxa() {
        return valorTotalTaxa;
    }

    public void setValorTotalTaxa(double valorTotalTaxa) {
        this.valorTotalTaxa = valorTotalTaxa;
    }

    public double getValorTotalLiquido() {
        return valorTotalLiquido;
    }

    public void setValorTotalLiquido(double valorTotalLiquido) {
        this.valorTotalLiquido = valorTotalLiquido;
    }
}
