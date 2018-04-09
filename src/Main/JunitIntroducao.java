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
        Departamento departamento = new Departamento(1, "ALIMENTO", 15);
        //Adiciona Funcionario
        Funcionario funcionario = new Funcionario(1, "2018", "Robson", "999", "000", true, departamento);
        //Adiciona Produtos
        Produto P1 = new Produto(2, 10, 5, departamento);
        Produto P2 = new Produto(3, 10, 10, departamento);
        Produto P3 = new Produto(4, 10, 15, departamento);
        
        //**Parte 2: Ação
        //Adicionando Venda
        Venda novaVenda = new Venda(funcionario, 1, "2018");
        //Adiciona VendaProduto
        VendaProduto VP0 = new VendaProduto(1, P1);
        VendaProduto VP1 = new VendaProduto(1, P2);
        VendaProduto VP2 = new VendaProduto(1, P3);
        
        novaVenda.AdicionarNaVenda(VP0);
        novaVenda.AdicionarNaVenda(VP1);
        novaVenda.AdicionarNaVenda(VP2);
        
        novaVenda.FinalizarVenda();
        
        //**Parte 3: Validação
        int maior = 15;
        int menor = 5;
        
        System.out.println(maior == novaVenda.maiorDeTodos);
        System.out.println(menor == novaVenda.menorDeTodos);
    }
}
