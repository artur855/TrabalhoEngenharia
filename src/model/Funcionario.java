package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {

    private int id;
    private String dataDeAdmissao;
    private String nome;
    private String cpf;
    private String rg;
    private boolean situacao;
    private Departamento departamento;
    private List<Venda> vendas;

    public Funcionario(String dataDeAdmissao, String nome, String cpf, String rg, boolean situacao, Departamento departamento, List<Venda> vendas) {
        this.dataDeAdmissao = dataDeAdmissao;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.situacao = situacao;
        this.departamento = departamento;
        this.vendas = vendas;
    }

    public Funcionario(int id, String dataDeAdmissao, String nome, String cpf, String rg, boolean situacao, Departamento departamento, List<Venda> vendas) {
        this(dataDeAdmissao, nome, cpf, rg, situacao, departamento, (vendas == null) ? vendas : new ArrayList<Venda>());
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(String dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
