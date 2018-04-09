package model;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private int idproduto;
    private int quantidade;
    private String nome;
    private int preco;
    private Departamento departamento;
    
    public Produto(int id, int quantidade, int preco, Departamento departamento) {
        this.idproduto = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return idproduto;
    }

    public void setId(int id) {
        this.idproduto = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
