package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Departamento;

public class DepartamentoDAO {

    private final String INSERT_QUERY = "INSERT INTO departamento (iddepartamento, sigla, comissao) VALUES (?, ?, ?)";

    public void insertDepartamento(Departamento departamento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            System.out.println(departamento.getId());
            System.out.println(departamento.getSigla());
            connection = DatabaseManager.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_QUERY);
            preparedStatement.setInt(1, departamento.getId());
            preparedStatement.setString(2, departamento.getSigla());
            preparedStatement.setFloat(3, departamento.getComissao());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeConnection(connection, preparedStatement);
        }
    }
}
