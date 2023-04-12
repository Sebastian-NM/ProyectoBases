package org.example.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PacienteTelefonoDAO {
    private Connection conn;

    public PacienteTelefonoDAO() {
        conn = ConexionBD.getConnection();
    }

    public void agregarTelefono(String patientID, String telefono) throws SQLException {
        String sql = "INSERT INTO pacienteTelefono (patientID, telefono) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, patientID);
        stmt.setString(2, telefono);
        stmt.executeUpdate();
        stmt.close();
    }

    public void eliminarTelefonosPorPaciente(String patientID) throws SQLException {
        String sql = "DELETE FROM pacienteTelefono WHERE patientID = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, patientID);
        stmt.executeUpdate();
        stmt.close();
    }

    public void actualizarTelefonosPorPaciente(String patientID, List<String> nuevosTelefonos) throws SQLException {
        // Eliminar los teléfonos existentes del paciente
        eliminarTelefonosPorPaciente(patientID);
        // Agregar los nuevos teléfonos del paciente
        for (String telefono : nuevosTelefonos) {
            agregarTelefono(patientID, telefono);
        }
    }
}