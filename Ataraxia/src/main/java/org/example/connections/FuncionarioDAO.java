package org.example.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.example.classes.CentroAtencion;
import org.example.classes.Funcionario;

public class FuncionarioDAO {

    private Connection connection;

    public FuncionarioDAO() {
        connection = ConexionBD.getConnection();
    }

    public void agregarFuncionario(Funcionario funcionario) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO funcionario(employeeID, employeeName, employeeType, employeeEnterDate, employeeArea, employeeCenter) VALUES (?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, funcionario.getEmployeeID());
            preparedStatement.setString(2, funcionario.getEmployeeName());
            preparedStatement.setString(3, funcionario.getEmployeeType());
            preparedStatement.setDate(4, new java.sql.Date(funcionario.getEmployeeEnterDate().getTime()));
            preparedStatement.setString(5, funcionario.getEmployeeArea());
            preparedStatement.setInt(6, funcionario.getEmployeeCenter());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarFuncionario(Funcionario funcionario) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE funcionario SET employeeName=?, employeeType=?, employeeEnterDate=?, employeeArea=?, employeeCenter=? WHERE employeeID=?");
            preparedStatement.setString(1, funcionario.getEmployeeName());
            preparedStatement.setString(2, funcionario.getEmployeeType());
            preparedStatement.setDate(3, new java.sql.Date(funcionario.getEmployeeEnterDate().getTime()));
            preparedStatement.setString(4, funcionario.getEmployeeArea());
            preparedStatement.setInt(5, funcionario.getEmployeeCenter());
            preparedStatement.setInt(6, funcionario.getEmployeeID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarFuncionario(int employeeID) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("DELETE FROM funcionario WHERE employeeID=?");
            preparedStatement.setInt(1, employeeID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Funcionario> obtenerTodosLosFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM funcionario");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setEmployeeID(resultSet.getInt("employeeID"));
                funcionario.setEmployeeName(resultSet.getString("employeeName"));
                funcionario.setEmployeeType(resultSet.getString("employeeType"));
                funcionario.setEmployeeEnterDate(resultSet.getDate("employeeEnterDate"));
                funcionario.setEmployeeArea(resultSet.getString("employeeArea"));
                funcionario.setEmployeeCenter(resultSet.getInt("employeeCenter"));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public Funcionario obtenerFuncionarioPorID(int employeeID) {
        Funcionario funcionario = new Funcionario();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM funcionario WHERE employeeID=?");
            preparedStatement.setInt(1, employeeID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                funcionario.setEmployeeID(resultSet.getInt("employeeID"));
                funcionario.setEmployeeName(resultSet.getString("employeeName"));
                funcionario.setEmployeeType(resultSet.getString("employeeType"));
                funcionario.setEmployeeEnterDate(resultSet.getDate("employeeEnterDate"));
                funcionario.setEmployeeArea(resultSet.getString("employeeArea"));
                funcionario.setEmployeeCenter(resultSet.getInt("employeeCenter"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }
}