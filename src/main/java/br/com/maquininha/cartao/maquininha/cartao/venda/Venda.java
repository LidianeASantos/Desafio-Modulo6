package br.com.maquininha.cartao.maquininha.cartao.venda;

import br.com.maquininha.cartao.maquininha.cartao.cliente.Cliente;
import br.com.maquininha.cartao.maquininha.cartao.resumovenda.ResumoVenda;

import javax.persistence.*;

@Entity
@Table(name="vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private double valor;
    private Opcao opcao;
    private int qtdParcela;
    private double taxa;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private ResumoVenda resumoVenda;


    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Opcao getOpcao() {
        return opcao;
    }

    public void setOpcao(Opcao opcao) {
        this.opcao = opcao;
    }

    public int getQtdParcela() {
        return qtdParcela;
    }

    public void setQtdParcela(int qtdParcela) {
        this.qtdParcela = qtdParcela;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }
}
