package org.example.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.classes.Paciente;
import java.sql.*;

public class PacienteDAO {
    private Connection connection;

    public PacienteDAO() {
        connection = ConexionBD.getConnection();
    }

    public void agregarPaciente(Paciente paciente) throws SQLException {
        // Insertar el nuevo paciente en la tabla "paciente"
        String query = "INSERT INTO paciente (patientID, patientName, patientBirthday, patientBloodType, patientNationality, patientAdress, patientCenter) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, paciente.getPatientID());
        statement.setString(2, paciente.getPatientName());
        statement.setDate(3, new java.sql.Date(paciente.getPatientBirthdayDate().getTime()));
        statement.setString(4, paciente.getPatientBloodType());
        statement.setString(5, paciente.getPatientNacionality());
        statement.setString(6, paciente.getPatientAdress());
        statement.setInt(7, paciente.getPatientCenter());
        statement.executeUpdate();

        PacienteTelefonoDAO daoT = new PacienteTelefonoDAO();

        List<String> listaNumeros = paciente.getPatientPhoneNumbers();
        for (int i = 0; i < listaNumeros.size(); i++) {
            daoT.agregarTelefono(paciente.getPatientID(), listaNumeros.get(i));
        }
    }

    public void eliminarPaciente(String patientID) throws SQLException {
        // Eliminar el paciente de la tabla "paciente"
        String query = "DELETE FROM paciente WHERE patientID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, patientID);
        statement.executeUpdate();
    
        // Eliminar los teléfonos del paciente de la tabla "paciente_telefono"
        PacienteTelefonoDAO daoT = new PacienteTelefonoDAO();
        daoT.eliminarTelefonosPorPaciente(patientID);
    }

    public void actualizarPaciente(Paciente paciente) throws SQLException {
        // Actualizar los datos del paciente en la tabla "paciente"
        String query = "UPDATE paciente SET patientName = ?, patientBirthday = ?, patientBloodType = ?, patientNationality = ?, patientAdress = ?, patientCenter = ? WHERE patientID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, paciente.getPatientName());
        statement.setDate(2, new java.sql.Date(paciente.getPatientBirthdayDate().getTime()));
        statement.setString(3, paciente.getPatientBloodType());
        statement.setString(4, paciente.getPatientNacionality());
        statement.setString(5, paciente.getPatientAdress());
        statement.setInt(6, paciente.getPatientCenter());
        statement.setString(7, paciente.getPatientID());
        statement.executeUpdate();
        
        // Actualizar los teléfonos del paciente en la tabla "paciente_telefono"
        PacienteTelefonoDAO daoT = new PacienteTelefonoDAO();
        daoT.eliminarTelefonosPorPaciente(paciente.getPatientID());
        List<String> listaNumeros = paciente.getPatientPhoneNumbers();
        for (int i = 0; i < listaNumeros.size(); i++) {
            daoT.agregarTelefono(paciente.getPatientID(), listaNumeros.get(i));
        }
    }
    
    public static boolean existePaciente(int id) {
        boolean existe = false;
        try {
            Connection conn = ConexionBD.getConnection();
            String sql = "SELECT * FROM paciente WHERE patientID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                existe = true;
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }
}