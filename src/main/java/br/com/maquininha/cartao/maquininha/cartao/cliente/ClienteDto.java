package br.com.maquininha.cartao.maquininha.cartao.cliente;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ClienteDto {

    @NotBlank(message = "{validacao.nome}")
    @Size(min = 10, message = "{validacao.nome}")
    private String nome;
    @NotBlank(message = "{validacao.estabelecimento}")
    private String estabelecimento;
    @NotBlank(message = "{validacao.email.obrigatorio}")
    @Email(message = "{validacao.email}")
    private String email;
    @NotBlank(message = "{validacao.senha}")
    private String senha;

    public ClienteDto() {
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
