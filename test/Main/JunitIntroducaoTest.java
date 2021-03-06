package Main;

import java.util.ArrayList;
import model.Departamento;
import model.Funcionario;
import model.Produto;
import model.Venda;
import model.VendaProduto;
import org.junit.Test;
import static org.junit.Assert.*;

public class JunitIntroducaoTest {

    @Test
    public void testSomeMethod() {
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
        
        assertEquals(maior, novaVenda.maiorDeTodos, 0.00001);
        assertEquals(menor, novaVenda.menorDeTodos, 0.00001);
    }
    
    @Test
    public void NaoPodeTerProdutoDuplicado(){
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
        VendaProduto VP1 = new VendaProduto(1, P1);
        VendaProduto VP2 = new VendaProduto(1, P3);
        
        novaVenda.AdicionarNaVenda(VP0);
        novaVenda.AdicionarNaVenda(VP1);
        novaVenda.AdicionarNaVenda(VP2);
        
        novaVenda.FinalizarVenda();
        //**Parte 3: Validação
        
        assertEquals(2, novaVenda.getListVendaProduto().size(), 0.00001);
        assertEquals(2, novaVenda.getListVendaProduto().get(0).getQuantidadeProduto());
    }
}
