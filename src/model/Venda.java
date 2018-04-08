package model;

import java.util.ArrayList;

public class Venda {

    private ArrayList<VendaProduto> listVendaProduto = new ArrayList<>();
    private Funcionario funcionario;
    private int idVenda;
    private float precoTotal;
    private String data;
    private float Comissao;
    private boolean Comissao_paga;

    public Venda(ArrayList<VendaProduto> VendaProduto, Funcionario Funcionario, int Id_Venda, String Data) {
        this.listVendaProduto = VendaProduto;
        this.funcionario = Funcionario;
        this.idVenda = Id_Venda;
        this.data = Data;
        GerarPrecoTotal();
        GerarComissao();
    }

    private void GerarPrecoTotal() {
        for (VendaProduto VP : this.listVendaProduto) {
            precoTotal += VP.getPreco();
        }
    }

    private void GerarComissao() {
        Comissao = precoTotal * (this.funcionario.getDepartamento().getComissao() / 100);
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float PrecoTotal) {
        this.precoTotal = PrecoTotal;
    }

    public ArrayList<VendaProduto> getListVendaProduto() {
        return listVendaProduto;
    }

    public void setListVendaProduto(ArrayList<VendaProduto> ListVendaProduto) {
        this.listVendaProduto = ListVendaProduto;
    }

    public float getComissao() {
        return Comissao;
    }

    public void setComissao(int Comissao) {
        this.Comissao = Comissao;
    }

    public boolean isComissao_paga() {
        return Comissao_paga;
    }

    public void setComissao_paga(boolean Comissao_paga) {
        this.Comissao_paga = Comissao_paga;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario Funcionario) {
        this.funcionario = Funcionario;
    }

    public int getId_Venda() {
        return idVenda;
    }

    public void setId_Venda(int Id_Venda) {
        this.idVenda = Id_Venda;
    }

    public String getData() {
        return data;
    }

    public void setData(String Data) {
        this.data = Data;
    }

}
