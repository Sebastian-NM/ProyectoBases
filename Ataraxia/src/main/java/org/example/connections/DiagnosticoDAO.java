package org.example.connections;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.classes.Diagnostico;

public class DiagnosticoDAO {
    private Connection conn;

    public DiagnosticoDAO() {
        conn = ConexionBD.getConnection();
    }

    // Método para agregar un diagnóstico a la base de datos
    public void agregarDiagnostico(Diagnostico d) {
        try {
            String query = "INSERT INTO diagnostico (diagnosticName, diagnosticLevel, diagnosticNotes, appointmentID) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, d.getDiagnosticName());
            ps.setString(2, d.getDiagnosticLevel());
            ps.setString(3, d.getDiagnosticNotes());
            ps.setInt(4, d.getAppointmentID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los diagnósticos de la base de datos
    public List<Diagnostico> obtenerTodosLosDiagnosticos() {
        List<Diagnostico> listaDiagnosticos = new ArrayList<Diagnostico>();
        try {
            String query = "SELECT * FROM diagnostico";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Diagnostico d = new Diagnostico(rs.getInt("appointmentID"), rs.getString("diagnosticName"), rs.getString("diagnosticLevel"), rs.getString("diagnosticNotes"));
                listaDiagnosticos.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDiagnosticos;
    }

    // Método para obtener un diagnóstico por su ID
    public Diagnostico obtenerDiagnosticoPorID(int diagnosticID) {
        Diagnostico d = null;
        try {
            String query = "SELECT * FROM diagnostico WHERE diagnosticID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, diagnosticID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                d = new Diagnostico(rs.getInt("appointmentID"), rs.getString("diagnosticName"), rs.getString("diagnosticLevel"), rs.getString("diagnosticNotes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    // Método para actualizar un diagnóstico en la base de datos
    public void actualizarDiagnostico(Diagnostico d) {
        try {
            String query = "UPDATE diagnostico SET diagnosticName = ?, diagnosticLevel = ?, diagnosticNotes = ?, appointmentID = ? WHERE diagnosticID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, d.getDiagnosticName());
            ps.setString(2, d.getDiagnosticLevel());
            ps.setString(3, d.getDiagnosticNotes());
            ps.setInt(4, d.getAppointmentID());
            ps.setInt(4, d.getDiagnosticID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un diagnóstico de la base de datos
    public void eliminarDiagnostico(int diagnosticID) {
        try {
            String query = "DELETE FROM diagnostico WHERE diagnosticID = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, diagnosticID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
