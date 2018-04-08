package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Departamento;
import model.Funcionario;
import model.Venda;

public class FuncionarioDAO {

    private final String INSERT_QUERY = "INSERT INTO funcionario (nome, cpf, rg, dataDeAdmissao, situacao, idDepartamento) VALUES (?, ?, ?, ?, ?)";
    private final String SELECT_FUNCIONARIOPORID_QUERY = "SELECT id, nome, cpf, rg, dataDeAdmissao, situacao, idDepartamento FROM funcionario f JOIN venda v ON f.id = v.idfuncionario WHERE id = ?";

    public void insertFuncionario(Funcionario funcionario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setString(0, funcionario.getNome());
            preparedStatement.setString(1, funcionario.getCpf());
            preparedStatement.setString(2, funcionario.getRg());
            preparedStatement.setString(3, funcionario.getDataDeAdmissao());
            preparedStatement.setBoolean(4, funcionario.isSituacao());
            preparedStatement.setInt(5, funcionario.getDepartamento().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement);
        }
    }

    public Funcionario getFuncionarioPorId(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        try {
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(SELECT_FUNCIONARIOPORID_QUERY);
            preparedStatement.setInt(0, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Departamento departamento = null;
                List<Venda> vendas = null;
                funcionario = new Funcionario(
                        resultSet.getInt("id"),
                        resultSet.getString("dataDeAdmissao"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("rg"),
                        resultSet.getBoolean("situacao"),
                        departamento,
                        vendas
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement, resultSet);
        }
        return funcionario;
    }
}
