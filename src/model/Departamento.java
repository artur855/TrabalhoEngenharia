package model;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private int iddepartamento;
    private String sigla;
    private float comissao;
    private Funcionario gerente;
    private List<Funcionario> funcionarios;
    private List<Produto> produtos;
    private List<Venda> vendas;

    public Departamento(int id, String sigla, float comissao) {
        this.iddepartamento = id;
        this.sigla = sigla;
        this.comissao = comissao;
        this.funcionarios = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public Departamento(int id, String sigla, float comissao, Funcionario gerente) {
        this(id, sigla, comissao);
        this.gerente = gerente;
    }

    public Departamento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return iddepartamento;
    }

    public void setId(int id) {
        this.iddepartamento = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public float getComissao() {
        return comissao;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void addProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public List<Venda> getVendas() {
        return vendas;
    }
}
