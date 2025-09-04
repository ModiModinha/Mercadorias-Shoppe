package br.com.MercShoppe.dev.MercShoppe_api.DTO;

import br.com.MercShoppe.dev.MercShoppe_api.Entity.Mercadoria;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

public class CategoriaCreateDTO {

    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Mercadoria> mercadorias;

    public CategoriaCreateDTO(){}

    public List<Mercadoria> getMercadorias() {
        return mercadorias;
    }

    public void setMercadorias(List<Mercadoria> mercadorias) {
        this.mercadorias = mercadorias;
    }

    public CategoriaCreateDTO(String nome, String descricao, List<Mercadoria> mercadorias){
        this.nome = nome;
        this.descricao = descricao;
        this.mercadorias = mercadorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }



}
