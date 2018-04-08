package model;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private int id;
    private int quantidade;
    private String nome;
    private int preco;
    private Departamento departamento;
    private List<VendaProduto> vendasProdutos;

    public Produto(int id, int quantidade, int preco, Departamento departamento) {
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
        this.vendasProdutos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<VendaProduto> getVendasProdutos() {
        return vendasProdutos;
    }

    public void addVendaProduto(VendaProduto vendaProduto) {
        this.vendasProdutos.add(vendaProduto);
    }
}
