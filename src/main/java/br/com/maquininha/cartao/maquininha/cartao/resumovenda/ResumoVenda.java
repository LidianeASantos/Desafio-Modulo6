package br.com.maquininha.cartao.maquininha.cartao.resumovenda;

import br.com.maquininha.cartao.maquininha.cartao.venda.Venda;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resumo_vendas")
public class ResumoVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double valorTotalVenda;
    private double valorTotalTaxa;
    private double valorTotalLiquido;

    @OneToMany
    private List<Venda> vendas;

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
