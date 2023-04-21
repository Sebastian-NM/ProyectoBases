package org.example;

import java.sql.Connection;
import org.example.classes.CentroAtencion;
import org.example.classes.Funcionario;
import org.example.classes.Paciente;
import org.example.connections.CentroAtencionDAO;
import org.example.connections.FuncionarioDAO;
import org.example.connections.PacienteDAO;
import org.example.connections.PacienteTelefonoDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.example.connections.ConexionBD;

public class Main {

    public static void main(String[] args) throws SQLException {
        CentroAtencionDAO dao = new CentroAtencionDAO();
        List<CentroAtencion> centros = dao.getAll();
        // Imprimir los centros de atención recuperados
        for (CentroAtencion centro : centros) {
            System.out.println(centro);
        }
    }
}
