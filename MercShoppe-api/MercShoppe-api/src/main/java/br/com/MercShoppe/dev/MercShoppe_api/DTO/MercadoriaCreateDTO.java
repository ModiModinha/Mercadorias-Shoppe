package br.com.MercShoppe.dev.MercShoppe_api.DTO;

import br.com.MercShoppe.dev.MercShoppe_api.Entity.Categoria;
import br.com.MercShoppe.dev.MercShoppe_api.Entity.Fornecedor;

import java.util.UUID;

public class MercadoriaCreateDTO {
    private String nome;
    private Double preco;
    private Integer quantidade;
    private Categoria categoria;
    private Fornecedor fornecedor;

    public MercadoriaCreateDTO(){
    }

    public MercadoriaCreateDTO(UUID id, String nome, Double preco, Integer quantidade, Categoria categoria, Fornecedor fornecedor){
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.fornecedor = fornecedor;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


}
