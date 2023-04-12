package org.example.connections;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.classes.Cita;

public class CitaDAO {
    private static final String INSERTAR_CITA_SQL = "INSERT INTO cita (appointmentID, appointmentStatus, appointmentSpecialty, appointmentDate, appointmentTime, appointmentNotes, appointmentAttendant) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR_CITA_SQL = "UPDATE cita SET appointmentStatus = ?, appointmentSpecialty = ?, appointmentDate = ?, appointmentTime = ?, appointmentNotes = ?, appointmentAttendant = ? WHERE appointmentID = ?";
    private static final String ELIMINAR_CITA_SQL = "DELETE FROM cita WHERE appointmentID = ?";
    private static final String OBTENER_CITA_POR_ID_SQL = "SELECT * FROM cita WHERE appointmentID = ?";
    private static final String OBTENER_TODAS_LAS_CITAS_SQL = "SELECT * FROM cita";

    public void agregarCita(Cita cita) {
        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(INSERTAR_CITA_SQL)) {
            pstmt.setInt(1, cita.getAppointmentId());
            pstmt.setString(2, cita.getAppointmentStatus());
            pstmt.setString(3, cita.getAppointmentSpecialty());
            pstmt.setDate(4, new java.sql.Date(cita.getAppointmentDate().getTime()));
            pstmt.setString(5, cita.getAppointmentTime());
            pstmt.setString(6, cita.getAppointmentNotes());
            pstmt.setString(7, cita.getAppointmentAttendant());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCita(Cita cita) {
        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(ACTUALIZAR_CITA_SQL)) {
            pstmt.setString(1, cita.getAppointmentStatus());
            pstmt.setString(2, cita.getAppointmentSpecialty());
            pstmt.setDate(3, new java.sql.Date(cita.getAppointmentDate().getTime()));
            pstmt.setString(4, cita.getAppointmentTime());
            pstmt.setString(5, cita.getAppointmentNotes());
            pstmt.setString(6, cita.getAppointmentAttendant());
            pstmt.setInt(7, cita.getAppointmentId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCita(int citaId) {
        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(ELIMINAR_CITA_SQL)) {
            pstmt.setInt(1, citaId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cita obtenerCitaPorId(int citaId) {
        Cita cita = null;
        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(OBTENER_CITA_POR_ID_SQL)) {
            pstmt.setInt(1, citaId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cita = new Cita(rs.getInt("appointmentID"), rs.getString("appointmentStatus"),
                        rs.getString("appointmentSpecialty"), rs.getDate("appointmentDate"),
                        rs.getString("appointmentTime"), rs.getString("appointmentNotes"),
                        rs.getString("appointmentAttendant"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cita;
    }

    public List<Cita> getAllCitas() {
        List<Cita> citas = new ArrayList<>();
        try (Connection conn = ConexionBD.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM cita")) {
            while (rs.next()) {
                int appointmentId = rs.getInt("appointmentID");
                String appointmentStatus = rs.getString("appointmentStatus");
                String appointmentSpecialty = rs.getString("appointmentSpecialty");
                Date appointmentDate = rs.getDate("appointmentDate");
                String appointmentTime = rs.getString("appointmentTime");
                String appointmentNotes = rs.getString("appointmentNotes");
                String appointmentAttendant = rs.getString("appointmentAttendant");
                Cita cita = new Cita(appointmentId, appointmentStatus, appointmentSpecialty,
                        appointmentDate, appointmentTime, appointmentNotes, appointmentAttendant);
                citas.add(cita);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }
}
