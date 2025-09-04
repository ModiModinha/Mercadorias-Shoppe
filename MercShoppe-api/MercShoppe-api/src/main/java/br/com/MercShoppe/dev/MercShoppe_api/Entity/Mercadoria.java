package br.com.MercShoppe.dev.MercShoppe_api.Entity;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.util.UUID;

@Entity
@Table(name = "mercadoria")
public class Mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "UUID")
    @Column(nullable = false, updatable = false)
    private UUID id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Double preco;
    @Column(nullable = false)
    private Integer quantidade;



    @ManyToOne
    @JoinColumn(name="categoria_id",nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name="fornecedor_id",nullable = false)
    private Fornecedor fornecedor;

    public Mercadoria(){
    }

    public Mercadoria(UUID id, String nome, Double preco, Integer quantidade){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
