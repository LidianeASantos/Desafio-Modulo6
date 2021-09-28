package br.com.maquininha.cartao.maquininha.cartao.venda;

import java.util.List;
import java.util.stream.IntStream;

public class VendaTotalDto {

    private List<VendaDto> vendas;
    private double valorTotal;

    public VendaTotalDto() {
    }

    public List<VendaDto> getVendas() {
        return vendas;
    }

    public void setVendas(List<VendaDto> vendas) {
        this.vendas = vendas;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
