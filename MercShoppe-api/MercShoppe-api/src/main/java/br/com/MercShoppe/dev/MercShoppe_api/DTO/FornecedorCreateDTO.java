package br.com.MercShoppe.dev.MercShoppe_api.DTO;

import br.com.MercShoppe.dev.MercShoppe_api.Entity.Mercadoria;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

public class FornecedorCreateDTO {

    private String nome;
    private String contato;
    private String endereco;
    @OneToMany(mappedBy = "categoria")
    private List<Mercadoria> mercadorias;

    public FornecedorCreateDTO(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public List<Mercadoria> getMercadorias() {
        return mercadorias;
    }

    public void setMercadorias(List<Mercadoria> mercadorias) {
        this.mercadorias = mercadorias;
    }

    public FornecedorCreateDTO(String nome, String contato, String endereco, List<Mercadoria> mercadorias){
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
        this.mercadorias = mercadorias;
    }
}
