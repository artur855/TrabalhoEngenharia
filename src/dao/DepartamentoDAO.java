package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Departamento;
import model.Funcionario;

public class DepartamentoDAO {

    private final String INSERT_QUERY = "INSERT INTO departamento (iddepartamento, sigla, comissao, idgerente) VALUES (?, ?, ?, ?)";
    private final String SELECT_BYID_QUERY = "SELECT d.iddepartamento, d.sigla, d.comissao, d.idgerente FROM departamento d join funcionario f on d.idgerente = f.idfuncionario WHERE d.iddepartamento = ?";
    private final String SELECT_ALL_QUERY = "SELECT d.iddepartamento, d.sigla, d.comissao, d.idgerente FROM departamento d join funcionario f on d.idgerente = f.idfuncionario";
    private final String DELETE_QUERY = "DELETE FROM departamento WHERE iddepartamento = ?";

    public void insertDepartamento(Departamento departamento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, departamento.getId());
            preparedStatement.setString(2, departamento.getSigla());
            preparedStatement.setFloat(3, departamento.getComissao());
            preparedStatement.setInt(4, (departamento.getGerente() == null) ? null : departamento.getGerente().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement);
        }
    }

    public Departamento getDepartamentoPorId(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Departamento departamento = null;
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_BYID_QUERY);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Funcionario funcionario = funcionarioDAO.getFuncionarioPorId(resultSet.getInt("idgerente"));
                departamento = new Departamento(
                        resultSet.getInt("id"),
                        resultSet.getString("sigla"),
                        resultSet.getFloat("comissao"),
                        funcionario
                );
                if (funcionario != null) {
                    funcionario.setDepartamento(departamento);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement);
        }
        return departamento;
    }

    public List<Departamento> getTodosDepartamentos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Departamento> departamentos = new ArrayList<>();
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement, resultSet);
        }
        return departamentos;
    }

    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement);
        }
    }
}
