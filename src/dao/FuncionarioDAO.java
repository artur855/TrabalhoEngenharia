package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Departamento;
import model.Funcionario;
import model.Venda;

public class FuncionarioDAO {

    private final String INSERT_QUERY = "INSERT INTO funcionario (idfuncionario, nome, cpf, rg, dataDeAdmissao, situacao, iddepartamento) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String SELECT_ALL_QUERY = "SELECT idfuncionario, nome, cpf, rg, dataDeAdmissao, situacao FROM funcionario";
    private final String SELECT_FUNCIONARIOPORID_QUERY = "SELECT f.idfuncionario, f.nome, f.cpf, f.rg, f.dataDeAdmissao, f.situacao, f.iddepartamento, d.sigla, d.comissao FROM funcionario f JOIN departamento d ON f.iddepartamento = d.iddepartamento WHERE f.idfuncionario = ?";
    private final String DELETE_QUERY = "DELETE FROM funcionario WHERE idfuncionario = ?";

    public Funcionario getFuncionarioPorId(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_FUNCIONARIOPORID_QUERY);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                funcionario = new Funcionario(
                        resultSet.getInt("idfuncionario"),
                        resultSet.getString("dataDeAdmissao"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("rg"),
                        resultSet.getBoolean("situacao"),
                        new Departamento(resultSet.getInt("iddepartamento"), resultSet.getString("sigla"), resultSet.getFloat("comissao")),
                        null
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement, resultSet);
        }
        return funcionario;
    }

    public void insertFuncionario(Funcionario funcionario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, funcionario.getId());
            preparedStatement.setString(2, funcionario.getNome());
            preparedStatement.setString(3, funcionario.getCpf());
            preparedStatement.setString(4, funcionario.getRg());
            preparedStatement.setString(5, funcionario.getDataDeAdmissao());
            preparedStatement.setBoolean(6, funcionario.isSituacao());
            preparedStatement.setInt(7, funcionario.getDepartamento().getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement);
        }
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

    public List<Funcionario> getTodosFuncionarios() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_ALL_QUERY);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario(
                        resultSet.getInt("id"),
                        resultSet.getString("dataDeAdmissao"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("rg"),
                        resultSet.getBoolean("situacao"),
                        null,
                        null);
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement, resultSet);
        }
        return funcionarios;
    }

}
