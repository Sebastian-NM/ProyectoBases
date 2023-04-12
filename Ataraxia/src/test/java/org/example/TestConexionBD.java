package org.example;

import org.example.connections.ConexionBD;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotNull;


public class TestConexionBD {
    @Test
    public void testGetConnection() {
        Connection conn = ConexionBD.getConnection();
        assertNotNull(conn);
        try {
            assertFalse(conn.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
