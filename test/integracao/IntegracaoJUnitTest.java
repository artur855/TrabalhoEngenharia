package integracao;

import dao.DepartamentoDAO;
import dao.FuncionarioDAO;
import java.util.List;
import model.Departamento;
import model.Funcionario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegracaoJUnitTest {

    public IntegracaoJUnitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        //DAO's
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();

        //Objetos para os testes
        Departamento departamento = new Departamento(1, "abc", 13);
        Funcionario funcionario1 = new Funcionario(1, "20/10/2010", "Arthur", "123.456.789-00", "1.234.567-8", true, departamento, null);
        Funcionario funcionario2 = new Funcionario(2, "01/02/2012", "Thiago", "666.666.666-69", "2.345.123-9", true, departamento, null);
        Funcionario funcionario3 = new Funcionario(3, "31/01/2011", "Edmario", "242.242.242-41", "0.142.423-6", true, departamento, null);
        departamento.setGerente(funcionario1);
        //Inserindo objetos de teste
        departamentoDAO.insertDepartamento(departamento);
        funcionarioDAO.insertFuncionario(funcionario1);
        funcionarioDAO.insertFuncionario(funcionario2);
        funcionarioDAO.insertFuncionario(funcionario3);
    }

    @After
    public void tearDown() {
        //DAO's
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();

        //Deletando objetos de teste
        funcionarioDAO.delete(1);
        funcionarioDAO.delete(2);
        funcionarioDAO.delete(3);
        departamentoDAO.delete(1);
    }

    @Test
    public void testeSelectFuncionarioComIdDoBanco() {
        //DAO
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        //Objeto de teste
        Funcionario funcionarioTest = funcionarioDAO.getFuncionarioPorId(1);

        //Comparações
        assertEquals(1, funcionarioTest.getId());
        assertEquals("Arthur", funcionarioTest.getNome());
        assertEquals("123.456.789-00", funcionarioTest.getCpf());
        assertEquals("1.234.567-8", funcionarioTest.getRg());
        assertEquals("20/10/2010", funcionarioTest.getDataDeAdmissao());
        assertEquals(1, funcionarioTest.getDepartamento().getId());
        assertEquals("abc", funcionarioTest.getDepartamento().getSigla());
    }

    @Test
    public void testeSelectTodosFuncionarioDoBanco() {
        //DAO
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        //Lista de funcionarios
        List<Funcionario> funcionarios = funcionarioDAO.getTodosFuncionarios();

        //Comparações
        assertEquals(3, funcionarios.size());
        assertEquals(true, funcionarios.get(0).isSituacao());
        assertEquals("Thiago", funcionarios.get(1).getNome());
        assertEquals("242.242.242-41", funcionarios.get(2).getCpf());

    }

    @Test
    public void testeFuncionarioGerenteDoDepartamento() {
        //Para fazer
        
        //DAO
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        
        //Listas
        Funcionario funcionario1 = funcionarioDAO.getFuncionarioPorId(1);
        Funcionario funcionario2 = funcionarioDAO.getFuncionarioPorId(2);
        Funcionario funcionario3 = funcionarioDAO.getFuncionarioPorId(3);
        Departamento departamento = departamentoDAO.getDepartamentoPorId(1);
        
        //Comparações
        assertEquals(departamento.getGerente(), funcionario1);
        assertNotEquals(departamento.getGerente(), funcionario2);
        assertNotEquals(departamento.getGerente(), funcionario3);
        
        
    }

}
