package br.com.maquininha.cartao.maquininha.cartao.cliente;

import br.com.maquininha.cartao.maquininha.cartao.venda.Venda;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Column(unique = true, nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String estabelecimento;
    @Id
    private String email;
    @Column(nullable = false)
    private String senha;

    @OneToMany
    private List<Venda> vendas;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(String estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
