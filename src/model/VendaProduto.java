/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author edmar
 */
public class VendaProduto {
    private int QuantidadeProduto;
    private float Preco;
    private Produto Produto;

    public VendaProduto(int QuantidadeProduto, Produto Produto) {
        this.QuantidadeProduto = QuantidadeProduto;
        this.Produto = Produto;
        GerarPrecoTotal();
    }
    
    private void GerarPrecoTotal(){
        this.Preco = QuantidadeProduto * Produto.getPreco();
    }
    
    /**
     * @return the QuantidadeProduto
     */
    public int getQuantidadeProduto() {
        return QuantidadeProduto;
    }

    /**
     * @param QuantidadeProduto the QuantidadeProduto to set
     */
    public void setQuantidadeProduto(int QuantidadeProduto) {
        this.QuantidadeProduto = QuantidadeProduto;
    }

    /**
     * @return the Preco
     */
    public float getPreco() {
        return Preco;
    }

    /**
     * @param Preco the Preco to set
     */
    public void setPreco(float Preco) {
        this.Preco = Preco;
    }

    /**
     * @return the Produto
     */
    public Produto getProduto() {
        return Produto;
    }

    /**
     * @param Produto the Produto to set
     */
    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }

    @Override
    public boolean equals(Object obj) {
        VendaProduto Vp = (VendaProduto) obj;
        if (Vp.getProduto().getId() == this.getProduto().getId()){
            return true;
        }else {
        return false;
        }
    }
}
