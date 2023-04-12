package org.example.connections;

import org.example.classes.CentroAtencion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CentroAtencionDAO {

    // Consultas SQL
    private static final String SELECT_ALL = "SELECT * FROM centroDeAtencion";
    private static final String SELECT_ONE = "SELECT * FROM centroDeAtencion WHERE centerID = ?";
    private static final String INSERT = "INSERT INTO centroDeAtencion (centerName, centerLocation, centerCapacity, centerType) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE centroDeAtencion SET centerName = ?, centerLocation = ?, centerCapacity = ?, centerType = ? WHERE centerID = ?";
    private static final String DELETE = "DELETE FROM centroDeAtencion WHERE centerID = ?";
    private static final String SELECT_BY_TYPE = "SELECT * FROM centroDeAtencion WHERE centerType = ?";


    // Conexión a la base de datos
    private Connection conn;

    public CentroAtencionDAO() {
        // Obtener la conexión de la clase ConexionBD
        this.conn = ConexionBD.getConnection();
    }


    // Obtener todos los centros de atención
    public List<CentroAtencion> getAll() {
        List<CentroAtencion> centros = new ArrayList<>();

        try {
            // Preparar la consulta SQL
            PreparedStatement statement = conn.prepareStatement(SELECT_ALL);
            ResultSet result = statement.executeQuery();

            // Recorrer el resultado y agregar cada centro a la lista
            while (result.next()) {
                int id = result.getInt("centerID");
                String name = result.getString("centerName");
                String location = result.getString("centerLocation");
                int capacity = result.getInt("centerCapacity");
                String type = result.getString("centerType");

                CentroAtencion centro = new CentroAtencion(id, name, location, capacity, type);
                centros.add(centro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return centros;
    }


    // Obtener un centro de atención por ID
    public CentroAtencion getById(int id) {
        CentroAtencion centro = null;

        try {
            // Preparar la consulta SQL
            PreparedStatement statement = conn.prepareStatement(SELECT_ONE);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            // Si se encontró un resultado, crear el objeto CentroAtencion correspondiente
            if (result.next()) {
                String name = result.getString("centerName");
                String location = result.getString("centerLocation");
                int capacity = result.getInt("centerCapacity");
                String type = result.getString("centerType");

                centro = new CentroAtencion(id, name, location, capacity, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return centro;
    }

    // Agregar un nuevo centro de atención
    public void add(CentroAtencion centro) {
        try {
            // Preparar la consulta SQL
            PreparedStatement statement = conn.prepareStatement(INSERT);
            statement.setString(1, centro.getCenterName());
            statement.setString(2, centro.getCenterLocation());
            statement.setInt(3, centro.getCenterCapacity());
            statement.setString(4, centro.getCenterType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar un centro de atención existente
    public void update(CentroAtencion centro) {
        try {
            // Preparar la consulta SQL
            PreparedStatement statement = conn.prepareStatement(UPDATE);
            statement.setString(1, centro.getCenterName());
            statement.setString(2, centro.getCenterLocation());
            statement.setInt(3, centro.getCenterCapacity());
            statement.setString(4, centro.getCenterType());
            statement.setInt(5, centro.getCenterID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un centro de atención existente
    public void delete(int id) {
        try {
            // Preparar la consulta SQL
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<CentroAtencion> getByType(String type) {
        List<CentroAtencion> centros = new ArrayList<CentroAtencion>();
        try {
            // Preparar la consulta SQL
            PreparedStatement statement = conn.prepareStatement(SELECT_BY_TYPE);
            statement.setString(1, type);
            // Ejecutar la consulta y obtener el resultado
            ResultSet result = statement.executeQuery();

            // Crear un objeto CentroAtencion por cada registro en el resultado y agregarlo a la lista
            while (result.next()) {
                CentroAtencion centro = new CentroAtencion();
                centro.setCenterID(result.getInt("centerID"));
                centro.setCenterName(result.getString("centerName"));
                centro.setCenterLocation(result.getString("centerLocation"));
                centro.setCenterCapacity(result.getInt("centerCapacity"));
                centro.setCenterType(result.getString("centerType"));
                centros.add(centro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return centros;
    }
}