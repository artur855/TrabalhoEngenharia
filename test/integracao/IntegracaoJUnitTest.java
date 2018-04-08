package integracao;

import dao.DepartamentoDAO;
import dao.FuncionarioDAO;
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
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFuncionarioDAO() {
        Departamento departamento = new Departamento(1, "abc", 13);
        Funcionario funcionario = new Funcionario(1, "20/10/2010", "Arthur", "123.456.789-00", "1.234.567-8", true, departamento, null);
        DepartamentoDAO departamentoDAO = new DepartamentoDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        departamentoDAO.insertDepartamento(departamento);
        funcionarioDAO.insertFuncionario(funcionario);
        Funcionario funcionarioTest = funcionarioDAO.getFuncionarioPorId(1);
        assertEquals(funcionario.getId(), funcionarioTest.getId());
        assertEquals(funcionario.getNome(), funcionarioTest.getNome());
        assertEquals(funcionario.getCpf(), funcionarioTest.getCpf());
        assertEquals(funcionario.getRg(), funcionarioTest.getRg());
        assertEquals(funcionario.getDataDeAdmissao(), funcionarioTest.getDataDeAdmissao());
        assertEquals(funcionario.getDepartamento().getId(), funcionarioTest.getDepartamento().getId());
        assertEquals(funcionario.getDepartamento().getSigla(), funcionarioTest.getDepartamento().getSigla());
    }

}
