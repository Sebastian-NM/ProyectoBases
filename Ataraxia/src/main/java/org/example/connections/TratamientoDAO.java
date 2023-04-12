package org.example.connections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.example.classes.Tratamiento;

public class TratamientoDAO {
    private Connection conn;

    public TratamientoDAO() {
        conn = ConexionBD.getConnection();
    }
    
    public void agregarTratamiento(Tratamiento tratamiento) {
        String sql = "INSERT INTO tratamiento (treatmentID, treatmentName, treatmentDosis, treatmentType, appointmentID) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, tratamiento.getTreatmentID());
            ps.setString(2, tratamiento.getTreatmentName());
            ps.setInt(3, tratamiento.getTreatmentDosis());
            ps.setString(4, tratamiento.getTreatmentType());
            ps.setInt(5, tratamiento.getAppointmentID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarTratamiento(Tratamiento tratamiento) {
        String sql = "UPDATE tratamiento SET treatmentName=?, treatmentDosis=?, treatmentType=?, appointmentID=? WHERE treatmentID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tratamiento.getTreatmentName());
            ps.setInt(2, tratamiento.getTreatmentDosis());
            ps.setString(3, tratamiento.getTreatmentType());
            ps.setInt(4, tratamiento.getAppointmentID());
            ps.setInt(5, tratamiento.getTreatmentID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarTratamiento(int id) {
        String sql = "DELETE FROM tratamiento WHERE treatmentID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Tratamiento obtenerTratamientoPorID(int id) {
        String sql = "SELECT * FROM tratamiento WHERE treatmentID=?";
        Tratamiento tratamiento = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tratamiento = new Tratamiento(rs.getInt("treatmentID"), rs.getString("treatmentName"), rs.getInt("treatmentDosis"), rs.getString("treatmentType"), rs.getInt("appointmentID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamiento;
    }

    public List<Tratamiento> obtenerTodosLosTratamientos() {
        String sql = "SELECT * FROM tratamiento";
        List<Tratamiento> tratamientos = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tratamiento tratamiento = new Tratamiento(rs.getInt("treatmentID"), rs.getString("treatmentName"), rs.getInt("treatmentDosis"), rs.getString("treatmentType"), rs.getInt("appointmentID"));
                tratamientos.add(tratamiento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamientos;
    }
}