/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.util.ArrayList;
import model.Departamento;
import model.Funcionario;
import model.Produto;
import model.Venda;
import model.VendaProduto;

/**
 *
 * @author edmar
 */
public class JunitIntroducao {
    
    public static void main(String[] args) {
        //**Parte 1: Montar Cenario
        //Adiciona Departamento
        Departamento departamento = new Departamento(1, "ALIMENTO", 15, null);
        //Adiciona Funcionario
        Funcionario funcionario = new Funcionario(1, "2018", "Robson", "999", "000", true, departamento);
        //Adiciona Produtos
        Produto P1 = new Produto(2, 10, 5, departamento);
        Produto P2 = new Produto(3, 10, 10, departamento);
        Produto P3 = new Produto(4, 10, 15, departamento);
        //Adiciona VendaProduto
        VendaProduto VP0 = new VendaProduto(1, P1);
        VendaProduto VP1 = new VendaProduto(1, P2);
        VendaProduto VP2 = new VendaProduto(1, P3);
        
        ArrayList<VendaProduto> listaDeItens = new ArrayList<>();
        listaDeItens.add(VP0);
        listaDeItens.add(VP1);
        listaDeItens.add(VP2);
        
        //**Parte 2: Ação
        //Adicionando Venda
        Venda novaVenda = new Venda(listaDeItens, funcionario, 0, "2018");
        
        //**Parte 3: Validação
        System.out.println(novaVenda.maiorDeTodos);
        System.out.println(novaVenda.menorDeTodos);
    }
}